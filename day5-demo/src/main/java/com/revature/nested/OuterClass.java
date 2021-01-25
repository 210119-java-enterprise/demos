package com.revature.nested;

public class OuterClass {

    // Using a lambda in a static context.
    public static Operable op = (double a, double b) -> {
        return a * b;
    };



    // instanced scoped
    private int someNum;
    // Instance scoped inner classes have access to outer class's static variables
    // But not the other way around.
    private static int someStaticNum;
    // We can nest a class inside another class to determine a
    // shape of a custom state.



    // access modifiers are still applicable to inner types
    // also instance scoped
    public class InnerClass {
        private String innerState;

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }
        // The inner class has access to its parent's private members.
        public InnerClass(String innerState) {
            this.innerState = innerState + "and the outer state is: " + someNum;
        }
    }

    //
    public static class StaticInnerClass {
        private String innerState;

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }
        // The inner class has access to its parent's private members.
        public StaticInnerClass(String innerState) {
            this.innerState = innerState + "and the outer state is: " + someStaticNum;
        }
    }



}
