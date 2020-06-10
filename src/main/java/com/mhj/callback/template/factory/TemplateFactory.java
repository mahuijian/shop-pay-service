package com.mhj.callback.template.factory;

import com.mhj.callback.template.AbstractPayCallBackTemplate;
import com.mhj.utils.SpringContextUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 获取具体的实现模板工厂方法
 *
 * @author mahuijian
 * @date 2019-09-09 00:09
 */
@Component
public class TemplateFactory {
    public static AbstractPayCallBackTemplate getPayCallBackTemplate(String beanId) {
        return (AbstractPayCallBackTemplate) SpringContextUtil.getBean(beanId);
    }
}
