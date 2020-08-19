package com.dm;

/**
  * @className jvmtest 
  * @description TODO
  * @author dm
  * @date 2020/8/19
  * @since JDK1.8
  */
public class jvmtest {

    public static void main(String[] args) {
        int j = 0;
//        for (int i = 0; i < 1000; i++) {
//            j=++j;
//            j=j++;
//        }
        System.out.println(j);
    }
}

//iconst_0：将int类型常量0压入操作数栈
//istore_1：将int类型值存入局部变量1
//iload_1：从局部变量1中装载int类型值到操作数栈
//iinc：局部变量自增

//j=j++
// 0: iconst_0      入栈，将int类型常量0压入操作数栈    （局部变量-空，操作数栈-0）
// 1: istore_1      出栈，将int类型值存入局部变量1       （局部变量1-0，操作数栈-空）
// 2: iload_1       入栈，从局部变量1中装载int类型值，     （局部变量1-0，操作数栈-0）
// 3: iinc          1, 1  局部变量自增，把一个常量值加到一个int类型的局部变量中      （局部变量1-1，操作数栈-0）
// 6: istore_1      这一步覆盖了局部变量，所以局部变量变为1了，将int类型值存入局部变量1   （局部变量1-0，操作数栈-空）
//out:0

//j=++j
//0: iconst_0       入栈，,局部变量为空，操作数栈有一个元素0   （局部变量-空，操作数栈-0）
//1: istore_1       出栈，局部变量1=0，操作数栈没有元素        （局部变量1-0，操作数栈-空）
//2: iinc          1, 1    自增，局部变量1=1，操作数栈没有元素    （局部变量1-1，操作数栈-空）
//5: iload_1        入栈 将局部变量1入栈所以，局部变量不变，操作数栈有一个元素1   （局部变量1-1，操作数栈-1）
//6: istore_1       出栈，局部变量1=1，操作数栈没有元素   （局部变量1-1，操作数栈-空）
//out:1


//j++,++j
// 0: iconst_0
// 1: istore_1
// 2: iinc          1, 1
//out:1
