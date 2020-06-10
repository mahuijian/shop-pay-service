package com.mhj.service;

import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.entity.PaymentTransactionLogDTO;

/**
 * @author mahuijian
 * @date 2019-09-08 00:37
 */
public interface PaymentTransactionService {

    /**
     * 插入日志表
     */
    void insertpaymentTransaction(PaymentTransactionLogDTO paymentTransactionLogDTO);

    /**
     * 修改订单表
     */
    Integer updateOrderStatus(PaymentTransactionDTO paymentTransactionDTO);

    /**
     *
     * @param id id
     * @param paymentId 全局id
     * @return
     */
    PaymentTransactionDTO queryPaymentTransaction(Integer id, String paymentId);
}
