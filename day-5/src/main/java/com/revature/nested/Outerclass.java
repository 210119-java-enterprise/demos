package com.revature.nested;

/*
we can nest a class inside another class to determine
a shape of a custome state
access modifiers are sill applicable to inner types

 */
public class Outerclass {
    //sope? instance scoped
    private int someNum;
    public class Innerclass {
        private String innerState;

        public String getInnerState() {
            return innerState;
        }

        public void setInnerState(String innerState) {
            this.innerState = innerState;

        }

        //The inner class has access to its parents private members

        public void InnerClass(String innerState) {
            this.innerState = innerState + "and the outer stateis: " + someNum;
        }
    }
        public static class StaticInnerclass{
            private String innerState;

            public void getInnerState() {
            }
        }

}
