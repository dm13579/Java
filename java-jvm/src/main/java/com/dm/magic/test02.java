package com.dm.magic;

/**
  * @className test02 
  * @description TODO
  * @author dm
  * @date 2020/8/13
  * @since JDK1.8
  */
public class test02 {
    public static void main(String[] args) {
        System.out.println(Test.numA);
        System.out.println(InterfaceB.numA);
    }
}


interface InterfaceA{
    public static final Test2 test2 = new Test2();
}
interface InterfaceB extends InterfaceA{
    public static int numA = 1;
}

class Test implements InterfaceA{
    public static int numA = 1;
}

class Test2{
    public Test2() {
        System.out.println("我是Test2");
    }
}
