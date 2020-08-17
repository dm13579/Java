package com.dm.lambda;

import org.omg.CORBA.INTERNAL;

import java.util.function.Function;

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
  *@ClassName Test7
  *@Description Function函数式接口，类型转换
  *@Author dm
  *@Date 2020/7/22 0:13
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
public class Test7 {
    public static Integer function(String something, Function<String,Integer> function){
        return function.apply(something);
    }

    public static Integer addfunction(String something, Function<String,Integer> function1, Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(something);
    }

    public static void main(String[] args) {
        int a = function("4", Integer::parseInt);
        System.out.println(a);
        int b = addfunction("39", s -> Integer.parseInt(s), s -> s%10);
        System.out.println(b);

        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("5"));
    }
}
