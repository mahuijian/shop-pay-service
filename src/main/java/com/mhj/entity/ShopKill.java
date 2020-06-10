package com.mhj.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 秒杀库存表
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
@ApiModel("秒杀商品表")
public class ShopKill implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品库存id")
    private Integer seckillId;

    @ApiModelProperty("商品库存id")
    private String name;

    @ApiModelProperty("库存数量")
    private Integer inventory;

    @ApiModelProperty("秒杀开始时间")
    private Integer startTime;

    @ApiModelProperty("秒杀结束时间")
    private Integer endTime;

    @ApiModelProperty("创建时间")
    private Integer createTime;

    @ApiModelProperty("版本号")
    private Integer version;

}
