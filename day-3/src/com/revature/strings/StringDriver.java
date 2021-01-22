package com.revature.strings;

import java.sql.SQLOutput;

public class StringDriver {
    /*
    Topics
        >Memory managment of Strings (String pool)
        >String API(Application programing Interface
        >StringBuilder/StringBuffer classes
     */

    public static void main(String[] args){
        String s1="hello";
        String s2="hello";
        String s3=new String("hello");
        String s4=null;

        /*
        String pool
            >A special area inside of heap memory that
                java leverages to store String Objects with
                unique values. (implements the flywheel design pattern)

            >Not all Strings are stored in the String pool
                +if you explicitly use new to instatie te string
                +Strings that are returned from any String API method are not in the pool
           >If you use literal notation with the same value as
            an existing string,, a single string object will be stored in the pool.




         */

        System.out.println(s1==s2);//true, since we created two Strings using
                                        //literal notation

        System.out.println(s1==s3);//false, since we used the new keyword

        System.out.println(s1.equals(s3));//true; because we are cheacking value

        /*
        Stirng interning is the act of moving a String -which
            exists outside of the string pool -and interning or moving
            in into the string pool

         */
        String s5=s3.intern();
        System.out.println(s1==s3);
        //s3 techically didnt get interned, the method retured an interned string
        System.out.println(s2==s3);
        //also false
        System.out.println(s1==s5);
        //true, s5 regerence the same object as s1(and s2)

        /*
        The imutability of Strings
                -Strings are imutable (their value cant be changed
                +implicitly thred-safe as a result

         */

        String s6="hello ";
        s6.concat(",world");
        System.out.println(s6);
        //the result of .concat returned a new String and we ignored it
        s6=s6.concat(",world");
        System.out.println(s6);
        String s7="hello ,world";
        System.out.println(s6==s7);

        s6=s6.intern();
        System.out.println(s6==s7);


        /*
        String Builder and String buffer
            String builder
                -it does not extend the string class
                   -mutable
                    -cannot be instantiated using string literals
                    -not thread safe

              String Builder
                    -same thing but is thread safe


         */
        StringBuilder sb1=new StringBuilder("hello");
        StringBuffer sb2=new StringBuffer("hello");

        System.out.println(sb1.equals(sb2));//false
        //because for some reason string builder do not override
        //the .equals method from obect
        
    }
}
