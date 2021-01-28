package com.revature.nested;

public class OuterClass {
    //we can nest a class inside another class to determine a shape of a custom state
    //access modifiers are still applicable to inner types
    private int someNum;
    private static int someStaticNum;

    public class InnerClass{
        private String innerState;

        //the inner class has access to its parents private member
        public InnerClass(String innerState) {
            this.innerState = innerState + " and the outer state is: " + someNum +" and "+ someStaticNum;
        }

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }
    }

    //inner classes can be defined as static
    public static class StaticInnerClass{
        private String innerState;

        //the inner class has access to its parents private member
        public StaticInnerClass(String innerState) {
            this.innerState = innerState + " and the outer state is: " + someStaticNum;
        }

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }
    }

}
