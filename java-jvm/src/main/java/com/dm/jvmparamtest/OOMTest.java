package com.dm.jvmparamtest;

import com.dm.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 内存溢出代码
 *
 * 内存溢出自动导出dump文件
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=./（路径）
 * JVM设置
 * -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\jvm.dump
 * -XX:+PrintGCDetails 输出GC日志
 */
public class OOMTest {

    public static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}
