package com.peirato.demo.reflection.jdkproxy;

import com.peirato.demo.jdkproxy.JDKProxyFactory;
import com.peirato.demo.jdkproxy.SmsService;
import com.peirato.demo.jdkproxy.SmsServiceImpl;

/**
 * @Classname JDKProxyRun
 * @Description TODO
 * @Date 2021/4/14 3:09 下午
 * @Created by yangzeqi
 */
public class JDKProxyRun {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JDKProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
