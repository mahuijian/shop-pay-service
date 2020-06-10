package com.mhj.service.impl;

import com.mhj.config.HandlerPayContext;
import com.mhj.entity.PaymentChannelDTO;
import com.mhj.entity.PaymentTransactionDTO;
import com.mhj.mapper.PayContextDao;
import com.mhj.service.PayContextService;
import com.mhj.strategys.PayStrategy;
import com.mhj.utils.JwtUtil;
import com.mhj.web.ResponseObject;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author mahuijian
 * @date 2019-09-03 15:10
 */
@Service
public class PayContextServiceImpl implements PayContextService {

    private PayContextDao payContextDao;

    @Autowired
    private HandlerPayContext handlerPayContext;

    @Autowired
    public PayContextServiceImpl(PayContextDao payContextDao) {
        this.payContextDao = payContextDao;
    }

    @Override
    public ResponseObject toPayHtml(Integer orgId, Integer channelType, String payToken) {
        if (Objects.isNull(channelType)) {
            return ResponseObject.fail(400, "参数不能为空");
        }
        // 1.使用渠道id获取渠道信息
        PaymentChannelDTO paymentChannelDTO = payContextDao.queryPaymentChannelByType(orgId, channelType);
        if (Objects.isNull(paymentChannelDTO)) {
            return ResponseObject.fail(500, "查询不到渠道信息");
        }
        // 2.使用令牌获取支付参数
        PaymentTransactionDTO paymentTransactionDTO = getPaymentTransactionByToken(payToken).getData();
        if (Objects.isNull(paymentTransactionDTO)) {
            return ResponseObject.fail(500, "通过令牌获取参数错误，token已过期");
        }

        // 3.执行具体的支付渠道的算法获取html表单数据    策略模式，使用注解的形式
        PayStrategy payStrategy = handlerPayContext.getOrderStrategy(channelType);
        String payHtml = payStrategy.toPayHtml(paymentChannelDTO, paymentTransactionDTO);
        // 4.直接返回html
        return ResponseObject.success(payHtml);
    }

    @Override
    public ResponseObject<PaymentTransactionDTO> getPaymentTransactionByToken(String payToken) {
        if (StringUtils.isEmpty(payToken)) {
            return ResponseObject.fail(500, "支付令牌为空");
        }
        final Claims claims = JwtUtil.verifyAndGetClaimsByToken(payToken);
        if (Objects.isNull(claims)) {
            return ResponseObject.fail(500, "token错误");
        }
        String orderId = String.valueOf(claims.get("orderId"));
        // 通过order查询交易信息
        return ResponseObject.success(payContextDao.queryPaymentTransactionByOrderId(orderId));
    }

    @Override
    public ResponseObject refundBy(String paymentId) {
        if (StringUtils.isEmpty(paymentId)) {
            return ResponseObject.fail(500, "id不能为空");
        }


        return null;
    }
}
