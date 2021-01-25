package com.revature.nested;

import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class LongTester {

    private Long instanceValue;

    public LongTester(Long value) {
        this.instanceValue = value;
    }

    public Long getInstanceValue() {
        return instanceValue;
    }

    // lambda provides the implementation for the method 'test' on the instance of LongPredicate
    public final LongPredicate greaterThan = l -> instanceValue > l;

    public final LongPredicate lessThan = l -> instanceValue < l;

    public final LongPredicate equalTo = l -> l == instanceValue;

    public final LongPredicate LessThanOrEven = l -> (l<instanceValue)||(l%2==0);


    /*
    * boolean test(long l) {
    *   return [Whatever can go inside here can go to the right of the arrow];
    * }
    * */

    //provide a custom test for the instanceValue
    public boolean customTest(LongPredicate lp) {
        return lp.test(this.instanceValue);
    }


    public static void main(String[] args) {
        LongTester lt = new LongTester(5090L);

        System.out.println("is the lt value greater than 500? " + lt.greaterThan.test(500L));
        System.out.println("is the lt value less than 6000? " + lt.lessThan.test(6000L));
        System.out.println("is the lt value less than or equal to 5000? " + (lt.lessThan.test(5000L)||lt.equalTo.test(5000L)));

        //Is the instance value squared greater than 120,000
        boolean b = lt.customTest(l -> Math.pow(l, 2) > 120_000);
        boolean bWithReference = lt.customTest(lt.equalTo::test);
        lt.customTest(lt.greaterThan);

        System.out.println("did the custom test work? " + b);
        System.out.println("did the reference work? " + bWithReference);

    }
}
