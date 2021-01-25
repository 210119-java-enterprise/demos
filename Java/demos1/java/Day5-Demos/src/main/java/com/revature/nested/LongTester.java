package com.revature.nested;

import java.util.function.LongPredicate;

public class LongTester {

    private Long instanceValue;

    public LongTester(Long instanceValue) {
        this.instanceValue = instanceValue;
    }

    public Long getinstanceValue() {
        return instanceValue;
    }

    //instanceValue needs to be final either enforced or in logic
    //labmda provides implementations for the method test on the instance of long predicate
    public final LongPredicate greaterThan = l -> instanceValue > l;

    public final LongPredicate lessThan = l -> instanceValue <  l;

    public final LongPredicate equalTo = l -> l == instanceValue;

    public final LongPredicate lessThanOrEven = l -> (l<instanceValue)|| (0 == l % 2);

    public boolean customTest(LongPredicate lp) {
        return lp.test(this.instanceValue);
    }

    public static void main(String[] args) {
        LongTester lt = new LongTester(5090L);

        System.out.println("is the lt instanceValue greater than 500? " + lt.greaterThan.test(66L));
        System.out.println("is the lt instanceValue less than 500? " + lt.lessThan.test(66L));
        System.out.println("is the lt instanceValue equal to 500? " + lt.equalTo.test(66L));

        boolean b = lt.customTest(l -> Math.pow(1, 2) > 120);
        boolean bWithReference = lt.customTest(lt.greaterThan::test);
        lt.customTest(lt.greaterThan);
        System.out.println("did the custom test work? " + b);
        System.out.println("did the reference test work? " + bWithReference);


    }
}
