package com.revature.util;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> m0 = new Map<String, Integer>();
        m0.put("One", 1);
        m0.put("Two", 2);
        System.out.println("Testing put()... ");
        System.out.println((m0.getSize() == 2)? "\t1" : "\t1 failed");
        System.out.println((m0.getCapacity() == 16)? "\t2" : "\t2 failed");
        m0.put("Three", 3);
        m0.put("Four", 3);
        m0.put("Five", 3);
        m0.put("Six", 3);
        m0.put("Seven", 3);
        m0.put("Eight", 3);
        m0.put("Nine", 3);
        m0.put("Ten", 3);
        m0.put("Eleven", 3);
        m0.put("Twelve", 3);
        m0.put("Thirteen", 3);
        m0.put("Fourteen", 3);
        m0.put("Fifteen", 3);
        m0.put("Sixteen", 3);
        m0.put("Seventeen", 3);
        System.out.println((m0.getSize() == 17)? "\t3" : "\t3 failed");
        System.out.println((m0.getCapacity() == 32)? "\t4" : "\t4 failed");
        System.out.println((m0.put("Eighteen", 18) == null)? "\t5" : "\t5 failed");
        System.out.println((m0.put("Sixteen", 16) == 3)? "\t6" : "\t6 failed");
        System.out.println((m0.put(null, 4) == null)? "\t7" : "\t7 failed");

        System.out.println("Testing isEmpty()...");
        Map<String, Integer> m1 = new Map<String, Integer>();
        System.out.println(m1.isEmpty()? "\t1" : "\t1 failed");
        m1.put("One", 1);
        System.out.println(m1.isEmpty()? "\t2 failed" : "\t2");

        System.out.println("Testing get()...");
        System.out.println((m0.get("One") == 1)? "\t1" : "\t1 failed");
        System.out.println((m0.get("hi") == null)? "\t2" : "\t2 failed");
        System.out.println((m0.getOrDefault("Two", 4) == 2)? "\t3" : "\t3 failed");
        System.out.println((m0.getOrDefault("hi", 4) == 4)? "\t4" : "\t4 failed");
        System.out.println((m0.getOrDefault(null, 2) == 2)? "\t5" : "\t5 failed");

        System.out.println("Testing containsKey()...");
        System.out.println(m0.containsKey("One")? "\t1" : "\t1 failed");
        System.out.println(m0.containsKey("Nope")? "\t2 failed" : "\t2");
        System.out.println(m0.containsKey(null)? "\t3 failed" : "\t3");

        System.out.println("Testing remove()...");
        Map<String, Integer> m2 = new Map<String, Integer>();
        m2.put("One", 1);
        m2.put("Two", 2);
        m2.remove("One");
        System.out.println((m2.getSize() == 1)? "\t1" : "\t1 failed");
        System.out.println((m2.get("One") == null)? "\t2" : "\t2 failed");
        
        Map<String, Integer> m3 = new Map<String, Integer>();
        m3 = generateBasicMap();
        System.out.println(m3);
        System.out.println(m3.getSize());
        System.out.println((m3.getSize() == 17)? "\t3" : "\t3 failed");
        m3.remove("One");
        System.out.println(m3.getSize());
        System.out.println((m3.getSize() == 16)? "\t4" : "\t4 failed");
        m3.remove("Two");
        System.out.println(m3);
        System.out.println(m3.getSize());
        System.out.println((m3.getSize() == 15)? "\t4" : "\t4 failed");
        System.out.println((m3.getCapacity() == 16)? "\t5" : "\t5 failed");


    }

    public static Map<String, Integer> generateBasicMap() {
        Map<String, Integer> res = new Map<String, Integer>();
        res.put("One", 1);
        res.put("Two", 2);
        res.put("Three", 3);
        res.put("Four", 3);
        res.put("Five", 3);
        res.put("Six", 3);
        res.put("Seven", 3);
        res.put("Eight", 3);
        res.put("Nine", 3);
        res.put("Ten", 3);
        res.put("Eleven", 3);
        res.put("Twelve", 3);
        res.put("Thirteen", 3);
        res.put("Fourteen", 3);
        res.put("Fifteen", 3);
        res.put("Sixteen", 3);
        res.put("Seventeen", 3);


        return res;
    }
}
