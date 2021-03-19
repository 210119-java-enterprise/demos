package day3demo;
/*
 Topics:
    - Memory management of Strings
    - String API
    - StringBuilder/StringBuffer
*/
public class StringDriver {
    
    public static void main(String[] args) {
        // If strings are the same, will point to the same memory reference for efficiency (String pool)
        // No reference can change the other because strings are immutable
        String s1 = "North"; // added to string pool
        String s2 = "North"; // points to existing string in pool
        String s3 = new String("North"); // creates new string out of pool
        String s4 = "Nor"; // added to the string pool
        String s5 = s4.concat("th"); // points to new string outside of pool
        // All String api methods that return a string will return a new String (not in the pool)
        s5 = s1.intern(); // consolidates s5 reference to point to the s1 string in the pool
        s5 = s3.intern(); // this works too, even though s3 is not in string pool
        

        System.out.println(s3 == s5); // returns false. == checks reference equality
        System.out.println(s3.equals(s5)); // returns true. .equals() checks value equality
        System.out.println(s1 == s5); // returns true since s5 was interned


        // Strings are thread-safe because they are immutable
        String s6 = "hello";
        s6.concat(", world");
        System.out.println(s6); // concat returns new string
        s6 = s6.concat(", world");
        System.out.println(s6);

        String s7 = "hello, world";
        System.out.println(s6 == s7); // returns false since concat returns a new string (outside of pool)

        String s8 = "hello" + ", world";
        System.out.println(s7 == s8); // true (string + is not a String API method)
        System.out.println(s6 == s8); // false since s8 is in the string pool and s6 is outside

        /*
        StringBuilder and StringBuffer have same API methods
        Both do not extend the String class
        Both are mutable
        Neither cannot be instantiated with a string literal
        StringBuilder is not thread-safe
        StringBuffer is thread-safe (slower than StringBuilder)
        */

        // StringBuilder sb1 = "Doesn't work";
        StringBuilder sb2 = new StringBuilder("hello");
        StringBuilder sb3 = new StringBuilder("hello");

        System.out.println(sb2 == sb3); // false, as there is no pool for StringBuilders (no reference equality)
        System.out.println(sb2.equals(sb3)); // false, as there is no override for object.equals()
                                                // object.equals() does ==
        sb2.append(", world"); // changes sb2
        System.out.println(sb2);
    }

}
