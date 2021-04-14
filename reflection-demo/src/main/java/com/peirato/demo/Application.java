package com.peirato.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname Application
 * @Description TODO
 * @Date 2021/4/14 2:35 下午
 * @Created by yangzeqi
 */
public class Application {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        getClazz();
        runMethod();
    }

    /**
     * 四种获取class的方式
     */
    public static void getClazz() throws ClassNotFoundException {

        Class<TargetObject> clazz = TargetObject.class;
        System.out.println("clazz :" + clazz.getName());

        Class<?> clazz2 = Class.forName("com.peirato.demo.TargetObject");
        System.out.println("clazz2 :" + clazz2.getName());

        TargetObject targetObject = new TargetObject();
        System.out.println("clazz3 :" + targetObject.getClass().getName());

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.peirato.demo.TargetObject");
        System.out.println("clazz4 :"+clazz4.getName());

    }

    public static void runMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        
        // 获取class对象和创建实例
        Class<?> clazz = Class.forName("com.peirato.demo.TargetObject");
        TargetObject targetObject = (TargetObject) clazz.newInstance();

        // 获取全部方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        
        // 获取指定方法并调用
        Method publicMethod = clazz.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject,"JavaTest");

        // 获取指定参数并对参数进行修改
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject,"JavaTest");

        // 调用 private 方法

        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);

    }
}
