package com.peirato.demo.jdkproxy;

/**
 * @Classname SmsServiceImpl
 * @Description TODO
 * @Date 2021/4/14 3:13 下午
 * @Created by yangzeqi
 */
public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message: "+message);
        return message;
    }
}
