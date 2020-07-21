package com.dm.lambda;

import java.util.function.Consumer;

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
  *@ClassName Test5
  *@Description Consumer函數式接口，是一個消费邏輯
  *@Author dm
  *@Date 2020/7/21 23:49
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
public class Test5 {

    public static void consumer(String something, Consumer<String> consumer){
        consumer.accept(something);
    }

    public static void doubleConsumer(String something, Consumer<String> consumer1, Consumer<String> consumer2){
        consumer1.andThen(consumer2).accept(something);
    }

    public static void main(String[] args) {
        // lambda
        consumer("hello",s -> {
            System.out.println(s+" world");
        });

        // lambda
        doubleConsumer("hello",
                s -> System.out.println(s+" world"),
                s -> System.out.println(s+" bad"));
    }
}
