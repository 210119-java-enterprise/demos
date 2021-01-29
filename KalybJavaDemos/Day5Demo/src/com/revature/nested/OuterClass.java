package com.revature.nested;

public class OuterClass {
    // scope? instance scoped
    private int someNum;
    // instance scope
    private static int someStaticNum;

    public class InnerClass{
        private String innerState;

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }

        public InnerClass(String innerState) {
            this.innerState = innerState + " and the outer state is: " + someNum + someStaticNum;
        }
    }

    // inner classes can be defied with static scope.  this will change the bahavior and meaning
    // for the relationship between
    public static class StaticInnerClass{
        private String innerState;

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }

        public StaticInnerClass(String innerState) {
            this.innerState = innerState + " and the outer state is: " + someStaticNum;
        }
    }
}
