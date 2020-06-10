package com.mhj.callback.template.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.mhj.callback.template.AbstractPayCallBackTemplate;
import com.mhj.config.AlipayConfig;
import com.mhj.constant.PayConstant;
import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.service.PaymentTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝支付回调模板实现
 *
 * @author mahuijian
 * @date 2019-09-08 23:11
 */
@Component
@Slf4j
public class AliPayCallBackTemplate extends AbstractPayCallBackTemplate {

    @Autowired
    private PaymentTransactionService paymentTransactionService;

    @Override
    public Map<String, String> verifySignature(HttpServletRequest req, HttpServletResponse resq) {

        log.info("BackRcvResponse接收后台通知开始");
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(key, valueStr);
        }
        log.info(params.toString());

        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
            if (signVerified) {
                //商户订单号
                String paymentId = new String(req.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
                params.put("paymentId", paymentId);
                params.put(PayConstant.RESULT_CODE, PayConstant.RESULT_PAYCODE_200);
            } else {
                params.put(PayConstant.RESULT_CODE, PayConstant.RESULT_PAYCODE_201);
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("BackRcvResponse接收后台通知结束");
        return params;
    }

    @Override
    public String failResult() {
        return PayConstant.RESULT_FAIL;
    }

    @Override
    public String successResult() {
        return PayConstant.YINLIAN_RESULT_SUCCESS;
    }

    // 异步回调接口中，出现网络延迟，存在接口的幂等性问题
    @Override
    public String syncService(Map<String, String> map) {

        String tradeStatus = map.get("trade_status");

        String paymentId = map.get("paymentId");
        //判断交易状态TRADE_SUCCESS后，对涉及资金类的交易，请再发起查询接口查询，确定交易成功后更新数据库。
        // 1.出现问题，需要重试
        if (tradeStatus.equals("TRADE_FINISHED")) {
            return failResult();
        }
        //(如果出现错误，根据全局id查询，是否已经支付，网络重试，之前已经支付过)
        // 如果还是失败，进行手动补偿
        PaymentTransactionDTO payment = paymentTransactionService.queryPaymentTransaction(null, paymentId);
        if (0 == payment.getPaymentStatus()) {
            // 2.成功，修改订单的状态
            PaymentTransactionDTO paymentTransactionDTO = PaymentTransactionDTO.builder()
                    .paymentId(paymentId)
                    .paymentStatus(1)
                    .build();
            paymentTransactionService.updateOrderStatus(paymentTransactionDTO);
        }

        // 3.调用积分服务接口增加积分

        return successResult();
    }


}
