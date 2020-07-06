package com.dm.jvmparamtest;

/**
 * 线程找大小设置 -Xss128k(默认1M)
 */
public class StackOverFlowTest {

    static int count = 0;

    static void redo(){
        count++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println(count);
        }
    }
}
