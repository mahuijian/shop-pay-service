package com.mhj.strategys.impl;

import com.mhj.annotation.HandlePayType;
import com.mhj.entity.PaymentChannelDTO;
import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.strategys.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mhj
 * @date 2019/10/29
 */
@Slf4j
@HandlePayType(1)
@Component
public class WeixinStrategy implements PayStrategy {

    @Override
    public String toPayHtml(PaymentChannelDTO paymentChannelDTO, PaymentTransactionDTO paymentTransactionDTO) {
        log.info("进入微信支付------");

        return null;

    }
}
