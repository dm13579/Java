package com.dm.bean;

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
  *@ClassName User
  *@Description TODO
  *@Author dm
  *@Date 2020/7/4 17:02
  *@slogan: 我自横刀向天笑，笑完我就去睡觉
  *@Version 1.0
  **/
public class User1 {

    private int age;

    private String name;

    public User1() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void sout(){
        System.out.println("自己的类加载器加载");
    }
}
