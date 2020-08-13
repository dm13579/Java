package com.dm.magic;

/**
 * @author dm
 * @className test01
 * @description 类的初始化各种情况
 * @date 2020/8/13
 * @since JDK1.8
 */
public class test01 {
    public static void main(String[] args) {
//        System.out.println("=================="+classA.a);   // 1,
//        System.out.println("=================="+classB.b1);  // 2,
//        System.out.println("=================="+classB.b);   // 3,
//        System.out.println("=================="+classA.b1);  // 4,

//        classA.a = 22;
//        classA classA = new classA();

    }
}
class classB {
    public static final int b = 2;
    public static int b1 = 3;
    static {
        System.out.println("============B==============");
    }
}
class classA extends classB {
    public static int a = 1;
    static {
        System.out.println("============A==============");
    }
}
