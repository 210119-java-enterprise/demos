package com.revature.strings;

public class StringDriver {

    public static void main(String[] args) {
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            String pool

                - Special area in heap that stores String objects
                - Not all strings stored here -specifically declared object strings (new or String api) in heap
         */

        System.out.println(s1 == s2); //true - 2 strings with literal notation with same value point to same spot in
                                        // string pool
        System.out.println(s1 == s3); //false - explicitly used new keyword on s3 so it gives seperate obj ref
        System.out.println(s1.equals(s3)); //true - checking value equivilance

        // STRING INTERNING is the act of moving a string object in heap to the stringn pool

        String s5 = s3.intern();
        System.out.println(s1==s3); // s3 technically didnt get interned, the method returned an interned String
        System.out.println(s1 == s5); //true s5 references same object as s1 and s2

        // Immutability of strings - strings are immutable which means their value cant be changed once instanciated
        //                          -implicitly thread-safe as a result
        String s6 = "hello";
        s6.concat(", world!"); // result of .concat returns new string - need to put EX s6 = s6.concat...
        System.out.println(s6);

        s6 = s6.concat(", world!");
        String s7 = "hello, world!";
        System.out.println(s6 == s7); //using the concat string api causes this to fail
        System.out.println(s6.equals(s7)); //true
        s6 = s6.intern(); //sends the heap object s6 into the string pool
        System.out.println(s6 == s7); //true

        String s8 = "hello" + ", world!";
        System.out.println(s7==s8); //true - both in string pool - the + symbol does not count as string api aka

        //Stringbuilder and stringbuffer = -stringbuilder does not extend string, mutable, cannot be instanciated with literals
        //                                 not thread safe
                                //         -string buffer similar but is thread safe
        // stringbuilder good with single thread - multithread string buffer is safer

        // StringBuilder sb1 = "does not work";
        StringBuilder sb2 = new StringBuilder("hello");
        StringBuilder sb3 = new StringBuilder("hello");
        System.out.println(sb2==sb3); //false
        System.out.println(sb2.equals(sb3)); //false - doesnt extend string so doesnt act like string and doesnt override obj equals method

        sb2.append(", world!");
        System.out.println(sb2); // goes full helloworld because the appending works differnet then strings

        String s9 = sb2.toString();
        System.out.println(s7 == s9); //false - s9 gets outside the box becuase the tostring method provides obj ref from heap not pool


    }
}
