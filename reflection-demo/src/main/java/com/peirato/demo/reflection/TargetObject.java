package com.peirato.demo.reflection;

/**
 * @Classname TestClass
 * @Description TODO
 * @Date 2021/4/14 2:35 下午
 * @Created by yangzeqi
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

}
