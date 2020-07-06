package com.dm;

import com.dm.bean.User;

/**
 * 方便查看class字节码文件
 */
public class Math {

    public static int initData = 9;

    public static User user = new User();

    public int operate() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 8;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.operate();
    }
}
