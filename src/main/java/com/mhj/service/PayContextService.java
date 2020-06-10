package com.mhj.service;

import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.web.ResponseObject;

/**
 * @author mahuijian
 * @date 2019-09-03 15:09
 */
public interface PayContextService {

    /**
     * 生成html
     *
     * @param channelId channelId
     * @param payToken  payToken
     * @return html
     */
    ResponseObject toPayHtml(Integer orgId, Integer channelType, String payToken);

    /**
     * 通过令牌token获取支付参数
     */
    ResponseObject<PaymentTransactionDTO> getPaymentTransactionByToken(String payToken);

    /**
     * 支付宝退款
     *
     * @param paymentId 全局id（传给第三方的id）
     * @return payToken payToken
     */
    ResponseObject refundBy(String paymentId);
}
