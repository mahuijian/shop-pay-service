package com.mhj.controller;

import com.mhj.dto.PaymentDTO;
import com.mhj.service.PayContextService;
import com.mhj.service.impl.PaymentTransactionService;
import com.mhj.web.ResponseObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 聚合支付接口
 *
 * @author mahuijian
 * @date 2019-09-02 14:14
 */
@RestController
@RequestMapping("/pay")
@Api(tags = "支付", value = "支付")
public class PayController {

    private PaymentTransactionService paymentTransactionService;

    private PayContextService payContextService;

    /**
     * 生成token
     *
     * @param paymentDTO paymentDTO
     * @return token
     */
    @PostMapping("/generateToken")
    @ApiOperation(value = "生成token", notes = "生成token", response = String.class)
    public ResponseObject<String> generateToken(@Validated @RequestBody PaymentDTO paymentDTO) {
        return ResponseObject.success(paymentTransactionService.generateToken(paymentDTO));
    }

    /**
     * 聚合支付
     *
     * @param orgId       机构的id
     * @param channelType 渠道类型 0 银联   1微信   2支付宝
     * @param payToken    token
     * @return string html
     */
    @GetMapping("/toPay")
    public ResponseObject toPay(Integer orgId, Integer channelType, String payToken) {
        return payContextService.toPayHtml(orgId, channelType, payToken);

    }

    @Autowired
    public PayController(PaymentTransactionService paymentTransactionService, PayContextService payContextService) {
        this.paymentTransactionService = paymentTransactionService;
        this.payContextService = payContextService;
    }
}
