package com.dm.lambda;

import org.omg.CORBA.INTERNAL;

import java.util.Comparator;
import java.util.TreeSet;

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
  *@Date 2020/7/21 23:09
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
public class Test1 {

    public static Comparator<Integer> comparator(){
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
    }

    public static Comparator<Integer> comparator1(){
        return (o1,o2)->o2.compareTo(o1);
    }
    public static void main(String[] args) {
        // 匿名内部类
        Comparator<Integer> comparator = comparator();

        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        System.out.println(treeSet);
        System.out.println("====================================");

        // 使用lambda
        Comparator<Integer> comparator1 = comparator1();

        TreeSet<Integer> treeSet1 = new TreeSet<>(comparator1);
        treeSet1.add(1);
        treeSet1.add(3);
        treeSet1.add(2);
        System.out.println(treeSet1);
        System.out.println("====================================");

        // 无类型推断
        Comparator<Integer> comparator2 = (Integer o1,Integer o2)->o2.compareTo(o1);
        // 有类型推断
        Comparator<Integer> comparator3 = (o1,o2)->o2.compareTo(o1);
    }
}
