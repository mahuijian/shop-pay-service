package com.mhj.service.impl;

import com.google.common.collect.Maps;
import com.mhj.dto.PaymentDTO;
import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.mapper.PaymentTransactionDao;
import com.mhj.utils.IdWorkerUtil;
import com.mhj.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author mahuijian
 * @date 2019-09-02 14:15
 */
@Service
public class PaymentTransactionService {

    private PaymentTransactionDao paymentTransactionDao;

    public String generateToken(PaymentDTO paymentDTO) {

        // 插入一条预支付记录
        // 支付全局id
        String orderId = IdWorkerUtil.nextId() + "";
        PaymentTransactionDTO paymentTransactionDTO = PaymentTransactionDTO.builder()
                .orderId(orderId)
                .payAmount(paymentDTO.getTotalPrice())
                .userId(paymentDTO.getUserId())
                .paymentId(IdWorkerUtil.nextId().toString())
                .createTime(System.currentTimeMillis() / 1000)
                .createUser(paymentDTO.getUserId())
                .paymentStatus(0).build();
        Integer result = paymentTransactionDao.insertPaymentTransaction(paymentTransactionDTO);
        if (result == 0) {
            return "";
        }
        // 生成token
        Map<String, Object> map = Maps.newHashMap();
        map.put("orderId", orderId);
        map.put("userId", paymentDTO.getUserId());
        map.put("totalPrice", paymentDTO.getTotalPrice());
        return JwtUtil.generateToken(map);
    }

    @Autowired
    public PaymentTransactionService(PaymentTransactionDao paymentTransactionDao) {
        this.paymentTransactionDao = paymentTransactionDao;
    }
}