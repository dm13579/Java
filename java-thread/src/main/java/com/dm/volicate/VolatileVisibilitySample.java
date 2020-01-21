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
  * @ClassName:VolicateVisibilitySample 
  * @Description: volicate 可见性测试
  * @author dm
  * @date 2020/1/20
  * @slogan: 我自横刀向天笑，笑完我就去睡觉
  * @version V1.0
  */
public class VolatileVisibilitySample {

    volatile boolean flag = false;

    public void refresh() {
        this.flag = true;
        System.out.println("线程:" + Thread.currentThread().getName() + ":修改变量flag");
    }

    public void load(){
        while (!flag){

        }
        System.out.println("线程:" + Thread.currentThread().getName() + "当前线程嗅探到flag变量的改变");
    }

    public static void main(String[] args) {
        VolatileVisibilitySample volatileVisibilitySample = new VolatileVisibilitySample();
        Thread threadA = new Thread(() -> {
            volatileVisibilitySample.refresh();
        });
        Thread threadB = new Thread(() -> {
            volatileVisibilitySample.load();
        });

        // 先启动线程B,让B线程在while循环中空跑，等待嗅探到flag值改变。
        threadB.start();
        try{
           Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 线程A启动，看线程B是否可以嗅探到flag改变，如果可以证明volatile修饰的全局变量是对于所有线程是可见的。
        threadA.start();

        // 结果表明volatile是可见的。
    }

}
