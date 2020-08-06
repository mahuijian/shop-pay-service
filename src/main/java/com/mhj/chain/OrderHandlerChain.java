package com.mhj.chain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author mahuijian
 * @since 2020-08-06 14:27
 **/
@Component
public class OrderHandlerChain implements ApplicationContextAware {
    private List<AbstractHandler> chains = new ArrayList<>(10);

    int index = 0;

    public void handlerChain(OrderHandleContext orderHandleContext) {
        if (index < chains.size()) {
            AbstractHandler abstractHandler = chains.get(index);
            index++;
            abstractHandler.doHandle(orderHandleContext, this);
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, AbstractHandler> abstractHandlerMap = applicationContext.getBeansOfType(AbstractHandler.class);

        chains.addAll(abstractHandlerMap.values());
        // 根据处理器的权重，对处理器链中元素进行排序
        chains.sort(Comparator.comparingInt(AbstractHandler::weight));
    }
}
