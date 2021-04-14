package com.peirato.demo.cglib;

/**
 * @Classname CglibRun
 * @Description TODO
 * @Date 2021/4/14 6:19 下午
 * @Created by yangzeqi
 */
public class CglibRun {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) CglibProxyFactory.getProxy(SmsService.class);
        smsService.send("java");
    }
}
