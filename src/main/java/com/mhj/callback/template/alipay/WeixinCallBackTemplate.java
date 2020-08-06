package com.mhj.callback.template.alipay;

import com.mhj.callback.template.AbstractPayCallBackTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author mahuijian
 * @since 2020-08-06 10:25
 **/
@Component
@Slf4j
public class WeixinCallBackTemplate extends AbstractPayCallBackTemplate {
    @Override
    public Map<String, String> verifySignature(HttpServletRequest req, HttpServletResponse resq) {
        return null;
    }

    @Override
    public String failResult() {
        return null;
    }

    @Override
    public String successResult() {
        return null;
    }

    @Override
    public String syncService(Map<String, String> map) {
        return null;
    }
}
