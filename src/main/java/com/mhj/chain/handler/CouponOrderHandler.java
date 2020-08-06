package com.mhj.chain.handler;

import com.mhj.chain.AbstractHandler;
import com.mhj.chain.OrderHandleContext;
import com.mhj.chain.OrderHandlerChain;
import com.mhj.chain.OrderHandlerWeightEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 优惠券优惠
 *
 * @author mahuijian
 * @since 2020-08-06 14:50
 **/
@Component
@Slf4j
public class CouponOrderHandler extends AbstractHandler {
    @Override
    protected void doHandle(OrderHandleContext order, OrderHandlerChain chain) {
        if (StringUtils.hasLength(order.getOrderNo())) {
            log.info("优惠券已经扣减");
            order.setAmount(order.getAmount() - 10);
        }
        chain.handlerChain(order);
    }

    @Override
    protected int weight() {
        return OrderHandlerWeightEnum.COUPON.getCode();
    }
}
