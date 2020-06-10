package com.mhj.strategys;

import com.mhj.entity.PaymentChannelDTO;
import com.mhj.entity.PaymentTransactionDTO;

/**
 * 支付接口共同实现这个接口行为算法
 */
public interface PayStrategy {

    /**
     * @param paymentChannelDTO     渠道参数
     * @param paymentTransactionDTO 支付参数
     * @return String
     */
    String toPayHtml(PaymentChannelDTO paymentChannelDTO, PaymentTransactionDTO paymentTransactionDTO);
}
