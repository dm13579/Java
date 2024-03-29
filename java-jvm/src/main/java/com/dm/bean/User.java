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
public class User {

    private int id;

    private String uuid;

    private String name;

    public User() {
    }

    public User(int id, String uuid) {
        this.id = id;
        this.uuid = uuid;
    }

    public User(int id, String uuid, String name) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
