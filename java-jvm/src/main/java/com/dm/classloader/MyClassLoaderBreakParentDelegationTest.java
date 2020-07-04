package com.dm.classloader;

import java.lang.reflect.Method;

/**
 * 自定义类加载器(打破双亲委派机制)测试
 */
public class MyClassLoaderBreakParentDelegationTest extends ClassLoader {

    public static void main(String[] args) throws Exception {
        // 初始化自定义类加载器，会先初始化父类ClassLoader，
        // 其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoaderBreakParentDelegation classLoader = new MyClassLoaderBreakParentDelegation("D:/test");
        //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
        Class clazz = classLoader.loadClass("com.dm.bean.User1");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj, null);

        // 此时打印为MyClassLoaderBreakParentDelegation
        // 打破双亲委派机制
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

}
