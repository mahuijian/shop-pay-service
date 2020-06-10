package com.mhj.mapper;

import com.mhj.entity.PaymentTransactionDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mahuijian
 * @date 2019-09-03 11:36
 */
@Repository
public interface PaymentTransactionDao {

    /**
     * 插入预支付交易表
     *
     * @param paymentTransactionDTO paymentTransactionDTO
     * @return String
     */
    int insertPaymentTransaction(PaymentTransactionDTO paymentTransactionDTO);

    /**
     * 修改订单状态
     *
     * @param paymentTransactionDTO dto
     * @return int·
     */
    Integer updateOrderStatus(PaymentTransactionDTO paymentTransactionDTO);


    PaymentTransactionDTO queryPaymentTransaction(@RequestParam("paymentId") String paymentId);
}
