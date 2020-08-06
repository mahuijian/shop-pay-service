package com.mhj.chain;

/**
 * @author mahuijian
 * @since 2020-08-06 14:25
 **/
public abstract class AbstractHandler {

    protected abstract void doHandle(OrderHandleContext context, OrderHandlerChain chain);

    /**
     * 订单处理器的权重
     */
    protected abstract int weight();
}
