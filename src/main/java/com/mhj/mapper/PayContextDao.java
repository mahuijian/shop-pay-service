package com.mhj.mapper;

import com.mhj.entity.PaymentChannelDTO;
import com.mhj.entity.PaymentTransactionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayContextDao {

    PaymentChannelDTO queryPaymentChannelByType(@Param("orgId") Integer orgId, @Param("channelType") Integer channelType);

    /**
     * 通过orderId查询信息
     *
     * @param orderId 订单的id
     * @return dto
     */
    PaymentTransactionDTO queryPaymentTransactionByOrderId(String orderId);
}
