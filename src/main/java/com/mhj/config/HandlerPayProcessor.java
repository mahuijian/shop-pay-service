package com.mhj.config;

import com.mhj.annotation.HandlePayType;
import com.mhj.strategys.PayStrategy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author mahuijian
 * @since 2020/6/9 11:59
 */
@Component
public class HandlerPayProcessor implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获取所有策略注解的Bean
        Map<String, Object> orderStrategyMap = applicationContext.getBeansWithAnnotation(HandlePayType.class);
        orderStrategyMap.forEach((k, v) -> {
            Class<PayStrategy> orderStrategyClass = (Class<PayStrategy>) v.getClass();
            int type = orderStrategyClass.getAnnotation(HandlePayType.class).value();
            //将class加入map中,type作为key
            HandlerPayContext.orderStrategyBeanMap.put(type, orderStrategyClass);
        });
        System.out.println();
    }
}
