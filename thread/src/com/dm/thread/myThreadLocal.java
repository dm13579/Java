package com.dm.thread;

import java.util.HashMap;
import java.util.Map;

public class myThreadLocal {
	static Map<Thread, String> threadMap = new HashMap<Thread, String>();

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<String>();
		threadLocal.set("dm");
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);

		String s = threadLocal.get();
		// ThreadLocal（线程本地变量）等同於下面的輸出，所以ThreadLocal可以线程保护，
		// 原因：Map中Thread 为key,而key值永远不会变。所以线程安全
//		String string = threadMap.get(Thread.currentThread());
//		System.out.println(string);
		System.out.println(s);
	}
}
