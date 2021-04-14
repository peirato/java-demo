package com.peirato.demo.cglib;


import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname MethodInterceptor
 * @Description TODO
 * @Date 2021/4/14 6:09 下午
 * @Created by yangzeqi
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method "+ method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        System.out.println("after method "+method.getName());
        return object;
    }
}
