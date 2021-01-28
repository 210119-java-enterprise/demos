package com.revature.nested;

import java.util.function.LongPredicate;

public class LongTester {
    private Long value;
    private Long instanceValue;
    public LongTester(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
    public long getInstanceValue(){
        return instanceValue;
    }


    //lambda provide implementation for the method 'test' on the instance of LongPredicate
    public final LongPredicate greaterThan=l->value>l;
    public final LongPredicate lessThan=l->value<l;
    public final LongPredicate equalTo=l->value==l;
    public final LongPredicate lessThanOrEven=l->l<instanceValue||l%2==0;

    public boolean customTest(LongPredicate lp){
        return lp.test(this.instanceValue);
    }

    public static void main(String[] args){
        LongTester lt=new LongTester(5090L);
        System.out.println("greater than 500"+lt.greaterThan.test(500L));
        System.out.println("less than 6000"+lt.lessThan.test(6000L));
        System.out.println("equal to 5090"+lt.equalTo.test(5090L));


        boolean b = lt.customTest(l->Math.pow(l,2)>120_000);
        boolean bWithReference = lt.customTest(lt.equalTo::test);
        lt.customTest(lt.greaterThan);

        System.out.println("did test work? "+b);
        System.out.println("did reference work? "+bWithReference);
    }
}
