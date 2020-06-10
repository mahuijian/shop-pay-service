package com.mhj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author mahuijian
 * @date 2019-09-02 14:06
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel("获取token的信息")
public class PaymentDTO {

    @NotNull(message = "订单id不能为空")
    @ApiModelProperty(value = "订单的id")
    private String orderId;

    @NotNull(message = "订单id不能为空")
    private Integer userId;

    @NotNull(message = "金额不能为空")
    private Long totalPrice;
}
