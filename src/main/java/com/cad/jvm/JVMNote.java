package com.cad.jvm;


/**
 * 1.jvm系统架构图
 * <p>
 * 2.类加载器
 * 2.1 有哪几种类加载器
 * 2.2 双亲委派
 * 2.3 沙箱安全机制
 * <p>
 * 3 Native
 * 3.1 native是一个关键字
 * 3.2 声明有，实现无
 * <p>
 * 4 PC寄存器
 * 4.1 记录了方法之间的调用和执行情况，类似排班值日表
 * 用来存储指向下一条指令的地址，也即将要执行的指令代码，它是当前线程所执行的字节码的行号指示器
 * <p>
 * 5 方法区
 * 5.1 它存储了每一个类的结构信息
 * 5.2 方法区是规范，在不同虚拟机里面实现是不一样的，最典型的就是永久代（PermGen space） 和元空间（Metaspace）
 * 空调 k1 = new 格力()
 * 方法区 f = new 永久代
 * 方法区 f = new 元空间
 * <p>
 * 6 stack
 * <p>
 * 6.1 栈管运行，堆管存储
 * 6.2 栈保存哪些东东？
 * 8种基本类型的变量，对象的引用变量，+实例方法都是在函数的栈内存中分配
 * <p>
 * 7 heap
 * <p>
 * 8 heap ---> 对象的生命周期 ---> OOM
 */

public class JVMNote {
    public int add(int x, int y) {
        int result = -1;
        result = x + y;
        return result;
    }

    public static void main(String[] args) {
        JVMNote ji = new JVMNote();

    }


}
