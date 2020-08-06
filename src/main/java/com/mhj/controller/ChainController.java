package com.mhj.controller;

import com.mhj.chain.OrderHandleContext;
import com.mhj.chain.OrderHandlerChain;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试责任链
 *
 * @author mahuijian
 * @date 2019-09-02 14:14
 */
@RestController
@RequestMapping("/chain")
@Api(tags = "测试责任链", value = "测试责任链")
public class ChainController {

    @Autowired
    private OrderHandlerChain orderHandlerChain;

    @GetMapping("getOrderMoney")
    public String chainTest() {
        OrderHandleContext order = new OrderHandleContext()
                .setOrderNo("123")
                .setAmount(100d)
                .setVipLevel(3)
                .setCouponNo("111");
        orderHandlerChain.handlerChain(order);
        System.out.println("订单最终金额为： " + order.getAmount());
        return order.getAmount() + "";


    }
}
