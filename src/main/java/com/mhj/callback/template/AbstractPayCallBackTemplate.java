package com.mhj.callback.template;

import com.alibaba.fastjson.JSONObject;
import com.mhj.constant.PayConstant;
import com.mhj.entity.PaymentTransactionLogDTO;
import com.mhj.service.PaymentTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 支付回调模板（设计模式之模板方法）
 *
 * @author mahuijian
 * @date 2019-09-08 00:12
 */
@Slf4j
public abstract class AbstractPayCallBackTemplate {

    @Autowired
    private PaymentTransactionService paymentTransactionService;

    /**
     * 获取所有的请求参数，封装成map集合，并且验证参数是否被篡改
     */
    public abstract Map<String, String> verifySignature(HttpServletRequest req, HttpServletResponse resq);

    public abstract String failResult();

    public abstract String successResult();

    /**
     * 异步回调执行的业务逻辑
     *
     * @param map map
     * @return String
     */
    public abstract String syncService(Map<String, String> map);

    /**
     * 1.验证报文参数
     * 2.将日志根据支付的id保存到数据库中
     * 3.执行异步回调业务逻辑
     *
     * @param req  req
     * @param resq resp
     * @return result
     */
    public String asyncCallBack(HttpServletRequest req, HttpServletResponse resq) {
        // 1.验签封装成map集合，并且验证参数是否被篡改
        Map<String, String> map = verifySignature(req, resq);

        String paymentId = map.get("paymentId");
        if (StringUtils.isEmpty(paymentId)) {
            return failResult();
        }

        // 2.日志保存数据库中
        PaymentTransactionLogDTO paymentTransactionLogDTO = PaymentTransactionLogDTO.builder()
                .transactionId(Long.valueOf(paymentId))
                .asyncLog(JSONObject.toJSONString(map))
                .build();
        // 3.采用异步形式写入数据库中
        payLog(paymentTransactionLogDTO);
        // 4.报文验签失败
        String result = map.get(PayConstant.RESULT_CODE);
        if (result.equals(PayConstant.RESULT_PAYCODE_201)) {
            return failResult();
        }
        // 5.异步的业务逻辑
        return syncService(map);
    }

    /**
     * 采用异步多线程或者mq
     *
     * @param paymentTransactionLogDTO paymentTransactionLogDTO
     */
    @Async
    private void payLog(PaymentTransactionLogDTO paymentTransactionLogDTO) {
        // 插入到数据库中
        paymentTransactionService.insertpaymentTransaction(paymentTransactionLogDTO);
    }
}
