package com.dm.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：杨过
 * @date ：Created in 2020/6/28
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description:
 **/
public class Juc_LockOnThisObject {

    private Integer stock = 10;

    public synchronized void decrStock(){
        --stock;
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }

    public static void main(String[] args) {
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        com.yg.edu.Juc_LockOnThisObject to = new com.yg.edu.Juc_LockOnThisObject();
        //System.out.println(ClassLayout.parseInstance(to).toPrintable());
        to.decrStock();

        com.yg.edu.Juc_LockOnThisObject to1 = new com.yg.edu.Juc_LockOnThisObject();
        to1.decrStock();
    }
}
