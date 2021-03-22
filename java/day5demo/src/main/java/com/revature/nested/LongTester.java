package com.revature.nested;

import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class LongTester {

    private Long myLong;
    public final LongPredicate greaterThan = l -> myLong > l;
    public final LongPredicate lessThan = l -> myLong < l;
    public final LongPredicate equal = l -> myLong == l;
    public final LongPredicate lessThanOrEven = l -> (myLong < l) || (myLong %2 == 0);
    // Same as greaterThan (autoboxes input to Long wrapper class if applicable)
    public final Predicate<Long> greaterThan2 = l -> myLong > l;


    public boolean customTest(LongPredicate lp) {
        return lp.test(this.myLong);
    }


    public LongTester(Long value) {
        this.myLong = value;
    }

    public Long getValue() {
        return myLong;
    }

    public static void main(String[] args) {
        LongTester lt = new LongTester(5040L);

        System.out.println("is lt value > 800?\t" + lt.greaterThan.test(800L));
        System.out.println("is lt value < 800?\t" + lt.lessThan.test(800L));
        System.out.println("is lt value = 800?\t" + lt.equal.test(800L));
        System.out.println("is lt value >= 2000?\t" + (lt.greaterThan.test(2000L)||lt.equal.test(2000L)));
        System.out.println("is lt value > 10,000?\t" + lt.greaterThan2.test(10_000L));

        Boolean b = lt.customTest(l -> Math.pow(l,2) > 120_000);
        System.out.println("is lt value^2 > 120k?\t" + b);
        // Compares myLong (because of implementation of greaterThan) to myLong
        //  (from implementation of customTest)
        Boolean b1 = lt.customTest(lt.equal::test);
        System.out.println("is lt == lt?\t\t" + b1);
        System.out.println("is lt value less than 200 or even?\t" + lt.lessThanOrEven.test(200L));

    }
}
