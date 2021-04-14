package com.peirato.demo.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @Classname JDKProxyFactory
 * @Description TODO
 * @Date 2021/4/14 3:16 下午
 * @Created by yangzeqi
 */
public class JDKProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                // 目标类的加载器
                target.getClass().getClassLoader(),
                // 代理类需要实现的接口
                target.getClass().getInterfaces(),
                // 代理类对象对应的自定义 InvocationHandler
                new DebugInvocationHandler(target)
        );
    }
}
