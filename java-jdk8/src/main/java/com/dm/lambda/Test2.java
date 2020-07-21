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
  *@ClassName Test2
  *@Description TODO
  *@Author dm
  *@Date 2020/7/21 23:19
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
public class Test2 {
    public static void newThread(Runnable runnable){
        new Thread(runnable).start();
    }
    public static void main(String[] args) {
        // 匿名内部类
        newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类当前线程-"+Thread.currentThread().getName());
            }
        });
        // lambda
        newThread(()->{
            System.out.println("lambda当前线程-"+Thread.currentThread().getName());
        });
        // lambda简化
        newThread(()->System.out.println("lambda简化版当前线程-"+Thread.currentThread().getName()));
    }
}
