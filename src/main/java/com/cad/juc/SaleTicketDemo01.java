package com.cad.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {// 资源类 = 实例变量+实例方法
    private int ticketNum = 30;
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if(ticketNum>0){
                System.out.println(Thread.currentThread().getName()+" 卖出第："+(ticketNum--)+" 还剩下："+ticketNum+"\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SaleTicketDemo01 {
    public static void main(String[] args) { // 主程序，一切程序的入口
        // 线程 操作 资源类
        Ticket ticket = new Ticket();
        new Thread(()->{for (int i = 0; i < 40; i++) ticket.sale(); },"A").start();
        new Thread(()->{for (int i = 0; i < 40; i++) ticket.sale(); },"B").start();
        new Thread(()->{for (int i = 0; i < 40; i++) ticket.sale(); },"C").start();

    }
}
