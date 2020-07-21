package com.dm.lambda;

/**
  *                  ,;,,;
  *                ,;;'(    
  *      __      ,;;' ' \   
  *   /'  '\'~~'~' \ /'\.)  
  * ,;(      )    /  |.     
  *,;' \    /-.,,(   ) \    
  *     ) /       ) / )|    
  *     ||        ||  \)     
  *    (_\       (_\
  *@ClassName Test
  *@Description TODO
  *@Author dm
  *@Date 2020/7/21 22:50
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
public class Test {
    public static void test(TestFunctionInterface testFunctionInterface){
        testFunctionInterface.test();
    }
    public static void main(String[] args) {
        // 普通实现类
        test(new TestFunctionInterfaceImpl());
        // 匿名内部类
        test(new TestFunctionInterface() {
            @Override
            public void test() {
                System.out.println("匿名内部类");
            }
        });
        // lambda
        test(()->{
            System.out.println("lambda");
        });
        // lambda 只有一条语句时可以省略掉大括号，return，和语句结尾的分号
        test(()->
            System.out.println("lambda简化")
        );
    }
}
