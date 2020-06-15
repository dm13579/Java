package com.dm.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class myThreadPool {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2,new MyThreadFactory());
		for(int i=0;i<10;i++) {
			executorService.execute(()->{
				System.out.println("my name:"+Thread.currentThread().getName());
				
				try {
					Thread.sleep(new Random().nextInt(10)*1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println("my name:"+Thread.currentThread().getName()+"execu finish");
			});
		}
		
		try {
			Thread.sleep(new Random().nextInt(1000)*1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	private static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                                  Thread.currentThread().getThreadGroup();
            namePrefix = "mythread-";
        }

        @Override
		public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            if (t.isDaemon()) {
				t.setDaemon(false);
			}
            if (t.getPriority() != Thread.NORM_PRIORITY) {
				t.setPriority(Thread.NORM_PRIORITY);
			}
            return t;
        }
    }
}
