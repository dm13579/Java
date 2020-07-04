package com.dm.classloader;

/**
 * 主类在运行过程中如果使用到其它类，会逐步加载这些类
 * jar包或war包里的类不是一次性全部加载的，是使用到时才加载。
 */
public class DynamicLoad {

    static {
        System.out.println("*************load TestDynamicLoad************"); // 1
    }

    public static void main(String[] args) {
        new A();
        System.out.println("*************load test************");  // 2
        B b = null;  //B不会加载，除非这里执行 new B()

//        运行结果：
//        *************load TestDynamicLoad************
//        *************load A************
//        *************initial A************
//        *************load test************
    }
}

class A {
    static {
        System.out.println("*************load A************");  // 3
    }

    public A() {
        System.out.println("*************initial A************"); // 4
    }
}

class B {
    static {
        System.out.println("*************load B************"); // 5
    }

    public B() {
        System.out.println("*************initial B************"); // 6
    }
}

