package com.mhj.chain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 封装处理器链处理元素上下文
 *
 * @author mahuijian
 * @since 2020-08-06 14:22
 **/
@Data
@Accessors(chain = true)
public class OrderHandleContext {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单金额
     */
    private Double amount;

    /**
     * VIP 等级
     */
    private Integer vipLevel;

    /**
     * 优惠券
     */
    private String couponNo;
}
