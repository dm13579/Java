package com.dm.thread;
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
  * @ClassName:deadLock 
  * @Description:TODO
  * @author dm
  * @date 2020/1/20
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
public class deadLock {

    private final static String resource_A = "A";

    private final static String resource_B = "B";

    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
           synchronized (resource_A){
               System.out.println("get resource_A");
               try {
                   Thread.sleep(3000);
                   synchronized (resource_B){
                       System.out.println("get resource_B");
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }

           }
        });

        Thread threadB = new Thread(()->{
            synchronized (resource_B){
                System.out.println("get resource_B");
                try {
                    Thread.sleep(3000);
                    synchronized (resource_A){
                        System.out.println("get resource_A");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        threadA.start();
        threadB.start();
    }
}
