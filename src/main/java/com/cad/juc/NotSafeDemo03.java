package com.cad.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 1 故障现象
 * java.util.ConcurrentModificationException
 * 2 导致原因
 * 3 解决方法
 * 3.1  new Vector<>()
 * 3.2  Collections.synchronizedList(new ArrayList<>())
 * 3.3 new CopyOnWriteArrayList()
 * 4 优化建议
 */
public class NotSafeDemo03 {

    public static void main(String[] args) {
        // listNotSafe();
        // setNotSafe();
        mapNotSafe();
    }


    public static void mapNotSafe() {
        // Map map = new HashMap();//线程不安全的
         Map map = new ConcurrentHashMap(); // 线程安全
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    public static void setNotSafe() {
         // Set<String> set = new HashSet<>();//线程不安全的
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    public static void listNotSafe() {
        // List<String> list = new ArrayList<>();//线程不安全的
        // List<String> list = new Vector<>();// 线程安全的
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
