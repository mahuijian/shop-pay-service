package com.mhj.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author mahuijian
 * @date 2019-09-03 11:38
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ApiModel("支付渠道的信息")
public class PaymentChannelDTO {

    private Integer id;

    private Integer orgId;

    @ApiModelProperty("支付类型 0银联 1微信  2支付宝")
    private Integer channelType;

    @ApiModelProperty("渠道名称")
    private String channelName;

    @ApiModelProperty("渠道id")
    private String channelId;

    @ApiModelProperty("商户的id")
    private String merchantId;

    @ApiModelProperty("同步的地址")
    private String syncUrl;

    @ApiModelProperty("异步的地址")
    private String asynUrl;

    @ApiModelProperty("公钥")
    private String publicKey;

    @ApiModelProperty("私钥")
    private String privateKey;

    @ApiModelProperty("版本号(主要作用:修改的时候条件行锁)")
    private Integer revision;

    @ApiModelProperty("支付状态 0待支付  1已支付  2支付超时")
    private Integer channelStatus;

    @ApiModelProperty("详情")
    private String reskRateInfo;

}
