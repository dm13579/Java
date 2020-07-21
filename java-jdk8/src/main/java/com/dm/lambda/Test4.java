package com.dm.lambda;

import java.util.function.Supplier;

/**
 * ,;,,;
 * ,;;'(
 * __      ,;;' ' \
 * /'  '\'~~'~' \ /'\.)
 * ,;(      )    /  |.
 * ,;' \    /-.,,(   ) \
 * ) /       ) / )|
 * ||        ||  \)
 * (_\       (_\
 *
 * @ClassName Test5
 * @Description Supplier函數式接口，给接口什么类型，它返回给你同样的类型
 * @Author dm
 * @Date 2020/7/21 23:37
 * @slogan: 我自横刀向天笑，笑完我就去睡觉
 * @Version 1.0
 **/
public class Test4 {
    public static String newString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static Integer getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        // lambda
        String str1 = newString(() -> {
            return "hello";
        });
        System.out.println("lambda:" + str1);

        // lambda简化
        String str12 = newString(() -> "hello");
        System.out.println("lambda简化:" + str12);

        Supplier<String> supplier = () -> new String("aaa");
        System.out.println(supplier.get());

        int[] arr = {1, 2, 3, 4, 12, 44, 1, 1431, 4124, 1241};
        int max = getMax(() -> {
            int rtn = arr[0];
            for (int i : arr) {
                if (i > rtn) {
                    rtn = i;
                }
            }
            return rtn;
        });
        System.out.println(max);
    }
}
