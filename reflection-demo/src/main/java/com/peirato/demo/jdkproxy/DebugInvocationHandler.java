package com.peirato.demo.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Classname DebugInvocationHandler
 * @Description JDK 动态代理类
 * @Date 2021/4/14 3:14 下午
 * @Created by yangzeqi
 */
public class DebugInvocationHandler implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method "+ method.getName());
        Object result = method.invoke(target,args);
        System.out.println("after method "+method.getName());
        return result;
    }
}
