package com.revature.nested;


public class OuterClass 
{
    // Instance scope (not accessible to static members)
    private int someNum;
    // Static scope
    private static int staticNum;


    // Can nest classes to determine shape of custom state
    // Not used super frequently
    // access modifiers still available
    // Instance scope
    public class InnerClass {
        private String innerState;

        public InnerClass() {
        }

        public InnerClass(String innerState) {
            this.innerState = innerState;
            // Can access outer class variables
            System.out.println("Outer state is: " + someNum + " + " + staticNum);
        }

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }

    }

    // Static scope
    public static class StaticClass {
        private String innerState;

        public StaticClass() {
        }

        public StaticClass(String innerState) {
            this.innerState = innerState;
            // Can access outer class variables (need to be static)
            System.out.println("Outer state is: " + staticNum + ", inner state is: " + this.innerState);
        }

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }

    }
}
