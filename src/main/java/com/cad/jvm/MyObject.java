package com.cad.jvm;

public class MyObject {
    public static void main(String[] args) {
        Object object = new Object();
        /*System.out.println(object.getClass().getClassLoader().getParent().getParent());
        System.out.println(object.getClass().getClassLoader().getParent());*/
        System.out.println(object.getClass().getClassLoader());

        System.out.println();
        System.out.println();
        System.out.println();

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());//虚拟机自带的加载器，启动类加载器或者叫根加载器（Bootstrap）C++，返回值为null
        System.out.println(myObject.getClass().getClassLoader().getParent());// 扩展类加载器（Extension）Java 返回值 sun.misc.Launcher$ExtClassLoader@1b6d3586
        System.out.println(myObject.getClass().getClassLoader());//应用程序类加载器（AppClassLoader）Java 返回值 sun.misc.Launcher$AppClassLoader@14dad5dc
    }
}
