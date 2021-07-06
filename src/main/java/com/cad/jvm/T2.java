package com.cad.jvm;

import java.util.Random;

public class T2 {

    public static void main(String[] args) {
        /*
        Thread t1 = new Thread();
        t1.start();
        t1.start();
        */
        // Exception in thread "main" java.lang.IllegalThreadStateException

        /*long maxMemory = Runtime.getRuntime().maxMemory();//返回Java虚拟机试图使用的最大内存值
        long totalMemory = Runtime.getRuntime().totalMemory();//返回Java虚拟机中的内存总量
        System.out.println("-Xmx:MAX_MEMROY = "+maxMemory+"（字节）、"+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("-Xms:TOTAL_MEMROY = "+totalMemory+"（字节）、"+(totalMemory/(double)1024/1024)+"MB");
        System.out.println("总内存："+(305664+699392+3180)/1024);*/
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        //byte[] bytes = new byte[1000*1024*1024];

        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        /*String str = "www.cad.com";
        while (true){
            str += str + new Random().nextInt(888888888) +  new Random().nextInt(99999999);
        }*/

      System.gc();

    }
}
