package com.dm.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * 类加载器测试
 */
public class JdkClassLoader {

    public static void main(String[] args) {
        // 引导类加载器加载
        System.out.println(String.class.getClassLoader());
        // 扩展类加载器加载
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        // 应用程序类加载器
        System.out.println(JdkClassLoader.class.getClassLoader().getClass().getName());

        System.out.println();
        // 类加载器关系 => 应用程序类加载器的父亲是扩展类加载器加载；扩展类加载器加载的父亲是引导类加载器加载；
        // 不是继承关系仅仅是逻辑上的父亲关系
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassloader.getParent();
        System.out.println("the bootstrapLoader : " + bootstrapLoader);
        System.out.println("the extClassloader : " + extClassloader);
        System.out.println("the appClassLoader : " + appClassLoader);

        System.out.println();

        // 引导类加载器加载文件
        System.out.println("bootstrapLoader加载以下文件：");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }

        // 扩展类加载器加载文件
        System.out.println();
        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        // 应用程序类加载器加载文件
        System.out.println();
        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));


//        运行结果：
//        null
//        sun.misc.Launcher$ExtClassLoader
//        sun.misc.Launcher$AppClassLoader
//
//        the bootstrapLoader : null
//        the extClassloader : sun.misc.Launcher$ExtClassLoader@2503dbd3
//        the appClassLoader : sun.misc.Launcher$AppClassLoader@14dad5dc
//
//        bootstrapLoader加载以下文件：
//        file:/C:/Program%20Files/Java/jdk1.8.0_73/jre/lib/resources.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_73/jre/lib/rt.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_73/jre/lib/sunrsasign.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_73/jre/lib/jsse.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_73/jre/lib/jce.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_73/jre/lib/charsets.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_73/jre/lib/jfr.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_73/jre/classes
//
//        extClassloader加载以下文件：
//        C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext;C:\Windows\Sun\Java\lib\ext
//
//        appClassLoader加载以下文件：
//        C:\Program Files\Java\jdk1.8.0_73\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\access-bridge-64.
//        jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\management- agent.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_73\jre\lib\rt.jar;D:\IdeaProjects\dm_demo\Java\java-jvm\target\classes;D:\developmenttool\JetBrains\IntelliJ IDEA 2019.3.4\lib\idea_rt.jar
    }

}
