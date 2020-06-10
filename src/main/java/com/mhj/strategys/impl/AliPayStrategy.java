package com.mhj.strategys.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.mhj.annotation.HandlePayType;
import com.mhj.config.AlipayConfig;
import com.mhj.entity.PaymentChannelDTO;
import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.strategys.PayStrategy;
import com.mhj.utils.AmountUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 支付宝支付渠道实现
 *
 * @author mahuijian
 * @date 2019-09-03 17:30
 */
@Slf4j
@HandlePayType(2)
@Component
public class AliPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml(PaymentChannelDTO paymentChannelDTO, PaymentTransactionDTO paymentTransactionDTO) {
        log.info("----------------支付宝支付------------");
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, paymentChannelDTO.getPrivateKey(), "json",
                AlipayConfig.charset, paymentChannelDTO.getPublicKey(), AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        alipayRequest.setReturnUrl(paymentChannelDTO.getSyncUrl());
        alipayRequest.setNotifyUrl(paymentChannelDTO.getAsynUrl());

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = paymentTransactionDTO.getPaymentId();
        //付款金额，必填
        String total_amount = null;
        try {
            total_amount = AmountUtils.changeF2Y(paymentTransactionDTO.getPayAmount().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //订单名称，必填
        String subject = "test测试";
        //商品描述，可空
        String body = paymentChannelDTO.getReskRateInfo();

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        log.info(result);
        return result;
    }

}
