package com.dm.lambda;

import java.util.function.Predicate;

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
 * @ClassName Test6
 * @Description Predicate函數式接口，是一個判斷邏輯
 * @Author dm
 * @Date 2020/7/21 23:57
 * @slogan: 我自横刀向天笑，笑完我就去睡觉
 * @Version 1.0
 **/
public class Test6 {
    public static boolean predicate(String something, Predicate<String> predicate) {
        return predicate.test(something);
    }

    public static boolean negpredicate(String something, Predicate<String> predicate) {
        return predicate.negate().test(something);
    }

    public static boolean andpredicate(String something, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.and(predicate2).test(something);
    }

    public static boolean orpredicate(String something, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.or(predicate2).test(something);
    }

    public static void main(String[] args) {
        String something = "hello";
        String something1 = "world";
        boolean a = predicate("handsome", something::equals);
        System.out.println(a);

        boolean b = negpredicate("handsome",s->{
            return something.equals(s);
        });
        System.out.println(b);

        boolean c = andpredicate("handsome", something::equals, something1::equals);
        System.out.println(c);

        boolean d = orpredicate("handsome",s-> something.equals(s),s-> something1.equals(s));
        System.out.println(d);
    }
}
