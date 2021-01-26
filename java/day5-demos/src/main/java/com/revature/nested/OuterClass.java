package com.revature.nested;

public class OuterClass {

    //using a lambda in a static context
    public static Operable op = (double a, double b) -> {
        return a + b;
    };

    //as long as the member is not final, redefine as needed
    static {
        op = (double a, double b) -> {
            return a*b;
        };
    }

    // scope? instance scoped
    private int someNum;
    // Instance scoped inner classes have access to outer class's static variables. but not the other way around.
    private static int someStaticNum;
    //We can nest a class inside another class to determine a shape of a custom state
    //  access modifiers are still applicable to inner types
    //      scope??? also instance
    public class InnerClass {
        private String innerState;

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }

        // The inner class has access to its parent's private members
        public InnerClass(String innerState) {
            this.innerState = innerState +" and the outer state is: " + someNum + someStaticNum;
        }
    }

    //inner classes can be defined with static scope. This will change the behavior and meaning
    //  for the relationship between the outer and inner classes though.
    public static class StaticInnerClass {
        private String innerState;

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }

        // The inner class has access to its parent's private members
        public StaticInnerClass(String innerState) {
            this.innerState = innerState +" and the outer state is: " + someStaticNum;
        }
    }
}


