package com.cad.juc;

class Aircondition {

    private int number = 0;

    public synchronized void increment() throws Exception {
        //1 判断
        while (number != 0) {
            this.wait();
        }
        //2 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 3 通知
        this.notifyAll();//唤醒其它等待的线程
    }

    public synchronized void decrement() throws Exception {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();//唤醒其它等待的线程
    }
}

/**
 * 题目：两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加1，一个线程对该变量减1
 * 实现交替，来10轮，变量初始值为0
 *
 * 1 高内聚低耦合前提下，线程操作资源
 * 2 判断/干活/通知
 * 3 防止多线程的虚假唤醒
 *
 */

public class ProdConsumerDemo04 {

    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

    }
}
