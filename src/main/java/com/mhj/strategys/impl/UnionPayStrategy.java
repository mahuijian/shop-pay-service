package com.mhj.strategys.impl;

import com.mhj.annotation.HandlePayType;
import com.mhj.entity.PaymentChannelDTO;
import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.strategys.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 银联支付渠道实现
 *
 * @author mahuijian
 * @date 2019-09-03 17:30
 */
@Slf4j
@HandlePayType(0)
@Component
public class UnionPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml(PaymentChannelDTO paymentChannelDTO, PaymentTransactionDTO paymentTransactionDTO) {
        log.info("银联支付参数封装-------------------");


        return null;
    }

}
