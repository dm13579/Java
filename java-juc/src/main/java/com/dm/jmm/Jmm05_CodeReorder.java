package com.dm.jmm;

import lombok.extern.slf4j.Slf4j;

/**
 * 指令重排证明代码
 **/
@Slf4j
public class Jmm05_CodeReorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = y = a = b = 0;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    shortWait(10000);
                    a = 1;
                    x = b;
//                    UnsafeInstance.reflectGetUnsafe().fullFence();
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
//                    UnsafeInstance.reflectGetUnsafe().fullFence();
                    y = a;
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String result = "第" + i + "次 (" + x + "," + y + "）";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            } else {
                log.info(result);
            }
        }

    }

    /**
     * 等待一段时间，时间单位纳秒
     *
     * @param interval
     */
    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
