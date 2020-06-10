package com.mhj.entity;

import lombok.*;

/**
 * @author mahuijian
 * @date 2019-09-03 11:38
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentTransactionDTO {

    private Integer id;

    private Long payAmount;

    private Integer userId;

    private Integer paymentStatus;

    private String orderId;

    private Integer pevision;

    private String paymentId;

    private Integer partyPayId;

    private Integer updateUser;

    private Long updateTime;

    private Long createTime;

    private Integer createUser;
}
