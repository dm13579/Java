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
		// ThreadLocal���̱߳��ر�������ͬ������ݔ��������ThreadLocal�����̱߳�����
		// ԭ��Map��Thread Ϊkey,��keyֵ��Զ����䡣�����̰߳�ȫ
//		String string = threadMap.get(Thread.currentThread());
//		System.out.println(string);
		System.out.println(s);
	}
}
