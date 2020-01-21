package com.dm.volicate;
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
  * @ClassName:VolatileAtom 
  * @Description:volatile 非原子性测试
  * @author dm
  * @date 2020/1/20
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
public class VolatileAtom {

    private static volatile int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
               for (int j = 0; j < 1000; j++){
                   count++;
               }
            });
            thread.start();
        }
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
