package com.dm.constantpool;

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
  *@ClassName test
  *@Description TODO
  *@Author dm
  *@Date 2020/7/5 23:59
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
public class test {
    public static void main(String[] args) {
        char[] b = {'b','b'};
        String bb = new String(b,0,2);
        String c = "bb";  // 1
        System.out.println(bb == bb.intern());// 3
        // 2
        System.out.println(bb == c.intern());

        // 1处代码 执行false false
        // 1处代码移到2处代码 执行true true
        // 删掉3处代码执行false
    }
}
