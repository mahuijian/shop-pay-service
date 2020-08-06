package com.mhj.chain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 封装处理器权重
 *
 * @author mahuijian
 * @since 2020-08-06 14:23
 **/
@Getter
@AllArgsConstructor
public enum OrderHandlerWeightEnum {

    COUPON(1, "优惠券"),
    SALES(2, "促销活动"),
    VIP(3, "VIP");
    private Integer code;
    private String desc;
}
