package com.mhj.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 秒杀订单表
 * </p>
 *
 * @author mahuijian
 * @since 2020-05-27
 */
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ApiModel("秒杀订单表")
public class ShopOrder implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品库存id")
    private Integer seckillId;

    @ApiModelProperty("手机号")
    private String userPhone;

    @ApiModelProperty("状态 1未支付 2已支付  3支付失败")
    private Integer state;

    @ApiModelProperty("创建时间")
    private Long createTime;

}
