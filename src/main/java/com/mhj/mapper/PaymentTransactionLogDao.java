package com.mhj.mapper;

import com.mhj.entity.PaymentTransactionLogDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionLogDao {

    void insertpaymentTransaction(PaymentTransactionLogDTO paymentTransactionLogDTO);
}
