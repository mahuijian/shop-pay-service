package com.mhj.service.impl;

import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.entity.PaymentTransactionLogDTO;
import com.mhj.mapper.PaymentTransactionDao;
import com.mhj.mapper.PaymentTransactionLogDao;
import com.mhj.service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mahuijian
 * @date 2019-09-08 00:37
 */
@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

    @Autowired
    private PaymentTransactionLogDao paymentTransactionLogDao;

    @Autowired
    private PaymentTransactionDao paymentTransactionDao;

    @Override
    public void insertpaymentTransaction(PaymentTransactionLogDTO paymentTransactionLogDTO) {
        paymentTransactionLogDao.insertpaymentTransaction(paymentTransactionLogDTO);
    }

    @Override
    public Integer updateOrderStatus(PaymentTransactionDTO paymentTransactionDTO) {
        paymentTransactionDTO.setUpdateUser(1);
        paymentTransactionDTO.setUpdateTime(System.currentTimeMillis() / 1000);
        return paymentTransactionDao.updateOrderStatus(paymentTransactionDTO);
    }

    @Override
    public PaymentTransactionDTO queryPaymentTransaction(Integer id, String paymentId) {
        PaymentTransactionDTO paymentTransactionDTO = paymentTransactionDao.queryPaymentTransaction(paymentId);
        return paymentTransactionDTO;
    }
}
