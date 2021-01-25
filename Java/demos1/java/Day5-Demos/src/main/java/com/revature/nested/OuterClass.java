package com.revature.nested;

public class OuterClass {

    public static Operable op = (double a, double b) -> {
        return a + b;
    };

    private int outerState;
    private static int staticOuterState;
    // we can nest a class inside another class to determine a shape of a custom state

    // access modifiers are still applicable to inner types
    public class InnerClass {

        private String innerState;

        public InnerClass(String innerState) {
            this.innerState = innerState;
        }

        public String getInnerState() {
            return innerState;
        }

        // Inner class has access to it's parents private members
        public void setInnerState(String innerState) {
            this.innerState = innerState + " and the outer state is: " + outerState;
        }

    }
    public static class StaticInnerClass {

        private String innerState;

        public StaticInnerClass(String innerState) {
            this.innerState = innerState;
        }

        public String getInnerState() {
            return innerState;
        }

        // Inner class has access to it's parents private members
        public void setInnerState(String innerState) {
            this.innerState = innerState + " and the outer state is: " + staticOuterState;
        }

    }

}


