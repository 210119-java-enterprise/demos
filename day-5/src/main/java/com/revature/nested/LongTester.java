package com.revature.nested;

import java.util.function.LongPredicate;

public class LongTester {
    Long value;

    public LongTester(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
//lambda provides the implementation for the method 'test' on the instance of LongPredicate
   public final LongPredicate greaterThan=l ->value>l;

    public final LongPredicate lessThan=l ->value<l;

    public final LongPredicate equalTo=l ->l==value;

    public final LongPredicate LessThanOrEven=l->(l<value)||(l%2==0);

    /*
    boolean test(Long l)
        return [whatever can go inside here can go to the right of the arrow];
    }
     */

    public boolean customTest(LongPredicate lp){
        return lp.test(this.value);
    }


    public static void main(String[] args){
        LongTester lt=new LongTester(5090L);

        System.out.println("is the lt value greater than 500? "+ lt.greaterThan.test(500L));
        System.out.println("is the lt value less than 6000?"+lt.lessThan.test(6000L));
        System.out.println("is the lt value less than or equal to 5000?"+(lt.lessThan.test(5000L)||lt.equalTo.test(5000L)));

        //is the value squared greated than 120_000?
       boolean b= lt.customTest(l->Math.pow(l,2)>120_000);
        System.out.println("did the custom test work?"+ b);


    }
}
