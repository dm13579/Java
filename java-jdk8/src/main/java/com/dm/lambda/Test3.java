package com.dm.lambda;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
  *@ClassName Test3
  *@Description TODO
  *@Author dm
  *@Date 2020/7/21 23:23
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
public class Test3 {
    public static void newThread(Runnable runnable){
        new Thread(runnable).start();
    }

    public static void main(String[] args) throws InterruptedException {
        final Date date = new Date();
        final Map<Integer,Object> map = new HashMap<>();
        map.put(1,2);
        // 匿名内部类
        newThread(new Runnable() {
            @Override
            public void run() {
                date.setTime(100000);
                map.put(1,3);
                System.out.println("匿名内部类当前线程-"+Thread.currentThread().getName());
            }
        });
        Thread.sleep(1000);
        System.out.println(map.get(1));
        // lambda
        newThread(() -> {
            date.setTime(200000);
            map.put(1,36);
            System.out.println("lambda当前线程-"+Thread.currentThread().getName());
        });
        Thread.sleep(1000);
        System.out.println(map.get(1));
        System.out.println("当前线程-"+Thread.currentThread().getName());
    }
}
