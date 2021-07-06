package com.cad.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printT(int pnum) {
        lock.lock();
        try {
            if (pnum == 5) {
                while (flag != 1) {
                    c1.await();
                }
            } else if (pnum == 10) {
                c2.await();
            } else if (pnum == 15) {
                c3.await();
            }
            for (int i = 1; i <= pnum; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 更新标志位
            // 通知
            if (pnum == 5) {
                flag = 2;
                c2.signal();
            } else if (pnum == 10) {
                flag = 3;
                c3.signal();
            } else if (pnum == 15) {
                flag = 1;
                c1.signal();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void print5(int pnum) {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            for (int i = 1; i <= pnum; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 更新标志位
            // 通知
            flag = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int pnum) {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 1; i <= pnum; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 更新标志位
            // 通知
            flag = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int pnum) {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 1; i <= pnum; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 更新标志位
            // 通知
            flag = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


/**
 * 多线程之间顺序调用 A->B->C
 * 三个线程执行顺序如下：
 * A打印5次，B打印10次，C打印15
 * 接着
 * A打印5次，B打印10次，C打印15
 * 来10轮
 */
public class ConditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.print5(5);
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.print10(10);
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareData.print15(15);
            }
        }, "CC").start();
    }
}
