package com.peirato.demo;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.stream.IntStream;

/**
 * @Classname main
 * @Description TODO
 * @Date 2021/4/8 6:06 下午
 * @Created by yangzeqi
 */
public class GroovyDemo {


    static class A {

        private int i = 0;

        private String a = "a";

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
//        GroovyShell groovyShell = new GroovyShell();
//        Object o = groovyShell.evaluate("5");
//        System.out.println(o);

        long l = System.currentTimeMillis();
        A a = new A();
        IntStream.range(0,10000).forEach(i->runGroovy2(a));

        System.out.println("end :" + (System.currentTimeMillis()-l)/1000.0);

    }

    public static void runGroovy2(A a){

        Binding binding = new Binding();
        binding.setVariable("a", a);

        GroovyShell groovyShell2 = new GroovyShell(binding);
        Object evaluate = groovyShell2.evaluate("a.getA()");
//        System.out.println(evaluate);
    }


}
