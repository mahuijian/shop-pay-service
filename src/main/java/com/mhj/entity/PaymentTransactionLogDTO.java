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
public class PaymentTransactionLogDTO {

    private Integer id;

    private String synchLog;

    private String asyncLog;

    private Integer channelId;

    private Long transactionId;

    // 乐观锁
    private Integer revision;

    private Integer updateUser;

    private Long updateTime;

    private Long createTime;

    private Integer createUser;
}
