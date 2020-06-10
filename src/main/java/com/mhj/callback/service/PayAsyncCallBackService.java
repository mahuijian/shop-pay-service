package com.mhj.callback.service;

import com.mhj.callback.template.AbstractPayCallBackTemplate;
import com.mhj.callback.template.factory.TemplateFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mahuijian
 * @date 2019-09-09 00:04
 */
@RestController
public class PayAsyncCallBackService {

    /**
     * 银联异步回调地址
     * @param req
     * @param resq
     * @return
     */
    @RequestMapping("/unionPayAsyncCallBack")
    public String unionPayAsyncCallBack(HttpServletRequest req, HttpServletResponse resq) {
        AbstractPayCallBackTemplate abstractPayCallBackTemplate = TemplateFactory.getPayCallBackTemplate("unionPayCallBackTemplate");
        return abstractPayCallBackTemplate.asyncCallBack(req,resq);
    }

    /**
     * 支付包异步回调地址
     * @param req
     * @param resq
     * @return
     */
    @RequestMapping("/aliPayAsyncCallBack")
    public String aliPayAsyncCallBack(HttpServletRequest req, HttpServletResponse resq) {
        AbstractPayCallBackTemplate abstractPayCallBackTemplate = TemplateFactory.getPayCallBackTemplate("aliPayCallBackTemplate");
        return abstractPayCallBackTemplate.asyncCallBack(req,resq);
    }
}
