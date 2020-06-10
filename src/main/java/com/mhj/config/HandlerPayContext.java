package com.mhj.config;

import com.mhj.strategys.PayStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mahuijian
 * @since 2020/6/9 11:38
 */
@Component
public class HandlerPayContext {

    public static Map<Integer, Class<PayStrategy>> orderStrategyBeanMap = new ConcurrentHashMap<>();

    public PayStrategy getOrderStrategy(Integer type) {

        try {
            Class<PayStrategy> strategyClass = orderStrategyBeanMap.get(type);
            if (strategyClass == null) {
                throw new IllegalArgumentException("没有对应的订单类型");
            }
            //从容器中获取对应的策略Bean
            return strategyClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
