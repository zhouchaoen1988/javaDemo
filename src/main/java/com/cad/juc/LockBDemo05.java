package com.cad.juc;


import java.util.concurrent.TimeUnit;

class Phone {

   /*public synchronized void sendEmail() throws Exception {
         TimeUnit.SECONDS.sleep(2);
       System.out.println("******sendEmail");
    }*/

    public static synchronized void sendEmail() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("******sendEmail");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println("******sendSMS");
    }

   /* public static synchronized void sendSMS() throws Exception {
        System.out.println("******sendSMS");
    }*/

    public void sayHello() throws Exception {
        System.out.println("******sayHello");
    }
}

/**
 * 8 lock
 * <p>
 * 1.标准访问，请问先打印邮件还是短信                               ---- 先打印邮件
 * 2.暂停4秒钟在邮件方法，请问先打印邮件还是短信                      ---- 先打印邮件
 * 3.新增普通方法sayHello，请问先打印邮件还是Hello                  ---- 先打印Hello
 * 4.两部手机，请问先打印邮件还是短信                               ---- 先打印短信
 * 5.两个静态同步方法，1部手机，请问先打印邮件还是短信                 ---- 先打印邮件
 * 6.两个静态同步方法，2部手机，请问先打印邮件还是短信                 ---- 先打印邮件
 * 7.1个静态同步方法，1个普通同步方法，1部手机，请问先打印邮件还是短信    ---- 先打印短信
 * 8.1个静态同步方法，1个普通同步方法，2部手机，请问先打印邮件还是短信    ---- 先打印短信
 * <p>
 * * 一个对象里面如果有多个synchronized方法，某一时刻内，只要一个线程去调用其中的一个synchronized方法了，
 * * 其它的线程都智能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
 * <p>
 * * 锁的是当前对象this，被锁定后，其它的线程都不能进入当前对象的其它的synchronized方法(锁1和锁2)
 * <p>
 * * 加个普通方法后发现和同步锁无关(锁3)
 * *
 * * 换成两个对象后，不是同一把锁了，情况立刻变化(锁4)
 * <p>
 * * synchronized实现同步的基础：Java中的每一个对象都可以作为锁
 * <p>
 * * 具体表现为以下3种形式：
 * <p>
 * * 对于普通方法，锁是当前实例对象，锁的是当前对象this
 * <p>
 * * 对于同步方法块，锁是synchronized括号里配置的对象
 * <p>
 * * 对于静态（static）同步方法，锁是当前类的class对象
 */
public class LockBDemo05 {

    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
                // phone.sendSMS();  // 锁1
                // phone.sendSMS();  // 锁2
                // phone.sayHello(); // 锁3
                // phone2.sendSMS(); // 锁4
                // phone.sendSMS();  // 锁5
                // phone2.sendSMS(); // 锁6
                 phone.sendSMS();  // 锁7
                // phone2.sendSMS(); // 锁8
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
