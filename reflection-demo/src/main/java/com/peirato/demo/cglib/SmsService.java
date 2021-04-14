package com.peirato.demo.cglib;

/**
 * @Classname AliSmsService
 * @Description 模拟发短信
 * @Date 2021/4/14 6:12 下午
 * @Created by yangzeqi
 */
public class SmsService {

    public String send(String message){
        System.out.println("send message:" + message);
        return message;
    }
}
