package com.revature.nested;

public class OuterClass{

    private int someNum = 1;
    private static int someStaticNum = 2;

    public class InnerClass {

        private String innerState;

        public InnerClass(String innerState){
            this.innerState = innerState + " and the outer state has " + someNum + " " + someStaticNum;
        }

        public String getInnerState(){
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }
    }

    public static class StaticInnerClass {

        private String innerState;

        public StaticInnerClass(String innerState){
            //cannot use someNum in a static sense, must have static variable
            this.innerState = innerState + " and the outer state has " + someStaticNum;
        }

        public String getInnerState(){
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;
        }
    }
}
