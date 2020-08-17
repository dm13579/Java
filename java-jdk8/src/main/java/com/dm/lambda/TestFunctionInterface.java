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
  *@InterfaceName TestFunctionInterface
  *@Description 函数式接口
  *@Author dm
  *@Date 2020/7/21 22:44
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
@FunctionalInterface
public interface TestFunctionInterface {
    // @FunctionalInterface注解会检查接口是否有且只有一个抽象方法，还可以有默认方法，和静态方法
    public void test();
    // 默认方法
    default String getName(){
        return "hello";
    }

    // 静态方法
    static String getName2(){
        return "world";
    }
}
