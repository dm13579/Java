package com.dm.jvmparamtest;

/**
  * 使cpu会飙起来
  */
public class CPUTest {

    public int operate() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 8;
        return c;
    }

    public static void main(String[] args) {
        CPUTest math = new CPUTest();
        while (true){
            math.operate();
        }
    }

}
