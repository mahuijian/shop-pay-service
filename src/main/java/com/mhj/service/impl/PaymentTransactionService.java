package com.mhj.service.impl;

import com.github.rholder.retry.RetryException;
import com.google.common.util.concurrent.FutureCallback;
import com.mhj.config.ProductRetryerBuilder;
import com.mhj.config.ThreadExecutorConfig;
import com.mhj.dto.PaymentDTO;
import com.mhj.mapper.PaymentTransactionDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/**
 * @author mahuijian
 * @date 2019-09-02 14:15
 */
@Service
@Slf4j
public class PaymentTransactionService {

    private PaymentTransactionDao paymentTransactionDao;

    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private ExecutorService executorService;

    public String generateToken(PaymentDTO paymentDTO) {
//        try {
//            ProductRetryerBuilder.build().call(()->testTask(1));
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (RetryException e) {
//            e.printStackTrace();
//        }
//        return "";

        transactionTemplate.execute(transactionStatus -> {
            log.info("执行事务中");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("执行事务中");
            return null;
        });


        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(100);

                System.out.println(NUMBER_OF_CORES);
                System.out.println("异步执行中");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);
        return "OK";


//        // 插入一条预支付记录
//        // 支付全局id
//        String orderId = OrderCodeUtil.getOrderCode(paymentDTO.getUserId().longValue());
//        PaymentTransactionDTO paymentTransactionDTO = PaymentTransactionDTO.builder()
//                .orderId(orderId)
//                .payAmount(paymentDTO.getTotalPrice())
//                .userId(paymentDTO.getUserId())
//                .paymentId(OrderCodeUtil.getUserOrderCode(paymentDTO.getUserId().longValue()))
//                .partyPayId(OrderCodeUtil.getAgainCode(paymentDTO.getUserId().longValue()))
//                .createTime(System.currentTimeMillis() / 1000)
//                .createUser(paymentDTO.getUserId())
//                .pevision(0)
//                .paymentStatus(0).build();
//        Integer result = paymentTransactionDao.insertPaymentTransaction(paymentTransactionDTO);
//        if (result == 0) {
//            return "";
//        }
//        // 生成token
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("orderId", orderId);
//        map.put("userId", paymentDTO.getUserId());
//        map.put("totalPrice", paymentDTO.getTotalPrice());
//        return JwtUtil.generateToken(map);
    }


    public Boolean testTask(int i) {
        return Objects.equals(i, 3);
    }

    @Autowired
    public PaymentTransactionService(PaymentTransactionDao paymentTransactionDao) {
        this.paymentTransactionDao = paymentTransactionDao;
    }
}
