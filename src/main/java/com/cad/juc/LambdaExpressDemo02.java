package com.cad.juc;


@FunctionalInterface
interface Foo {
    // public void sayHello();
    public int add(int x, int y);

    public default int mul(int x, int y) {
        return x * y;
    }

    public default int mul2(int x, int y) {
        return x * y;
    }

    public static int div(int x, int y) {
        return x / y;
    }

    public static int div2(int x, int y) {
        return x / y;
    }
}

/**
 * 1 语法：小括号，右箭头，大括号
 * 2 @FunctionalInterface
 * 3 default (接口中可以定义多个)
 * 4 static (接口中可以定义多个)
 */
public class LambdaExpressDemo02 {

    public static void main(String[] args) {

        Foo foo = (int x, int y) -> {
            System.out.println("come in to Lambda");
            return x + y;
        };
        System.out.println(foo.add(3, 5));
        System.out.println(foo.mul(3, 5));
        System.out.println(Foo.div(3, 5));
    }
}
