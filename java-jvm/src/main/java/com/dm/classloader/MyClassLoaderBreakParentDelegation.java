package com.dm.classloader;

import java.io.FileInputStream;

/**
 * 自定义类加载器(打破双亲委派机制)
 */
public class MyClassLoaderBreakParentDelegation extends ClassLoader {

    private String classPath;

    public MyClassLoaderBreakParentDelegation(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name
                + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    /**
     * 重写类加载方法，实现自己的加载逻辑，不委派给双亲加载
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t1 = System.nanoTime();

                // 非自定义的类还是走双亲委派加载
                if (!name.startsWith("com.dm")){
                    c = this.getParent().loadClass(name);
                }else{
                    c = findClass(name);
                }

                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

}
