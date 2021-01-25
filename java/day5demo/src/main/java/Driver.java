import com.revature.nested.Operable;
import com.revature.nested.OuterClass;
import com.revature.nested.Printable;
import com.revature.nested.SimpleAbstractSum;

import java.util.function.Predicate;

import static com.revature.nested.OuterClass.StaticInnerClass;

public class Driver {

    public static void main(String[] args){
        //to declare a new inner class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass("inner");
        //or
        OuterClass.InnerClass inner2 = new OuterClass().new InnerClass("inner2");

        System.out.println("+--------------------+");

        //do not need the instance (new keyword) unlike last time
        OuterClass.StaticInnerClass innerStatic = new OuterClass.StaticInnerClass("innerStatic");
        //can also if you import the static class (look above at import)
        StaticInnerClass innerStatic2 = new StaticInnerClass("innerStatic2");

        System.out.println("+--------------------+");
        //this only exists within the method scope
        //class declarations can be made anywhere
        class Try{
            private int someNum;
        }

        Try trial = new Try();

        if(true){
            class TryAgain{}
            TryAgain tryAgain = new TryAgain();
        }

        System.out.println("+--------------------------+");

        class nestedConcrete extends SimpleAbstractSum{

            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        }

        nestedConcrete nested = new nestedConcrete();
        System.out.println(nested.sum(3,4));

        System.out.println("+----------------------+");

        /*
            Here you are implementing an interface that you only need to use for this instance
            You can have this general idea of operable for 2 inputs
            Later you can create a class that implements with addition or division or whatever
         */
        class OperableImpl implements Operable{

            @Override
            public double operate(double a, double b) {
                return a*b;
            }
        }

        OperableImpl opImp = new OperableImpl();
        System.out.println(opImp.operate(5.5, 7.6));

        System.out.println("+-------------------------+");

        //anonymous classes in java 7
        SimpleAbstractSum simple = new SimpleAbstractSum() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };
        System.out.println(simple.sum(3,4));

        Operable op = new Operable() {
            @Override
            public double operate(double a, double b) {
                return a*b;
            }
        };
        System.out.println(op.operate(3.5,7.5));

        System.out.println("+------------------+");
        //anonymous classes in java 8 (lambda expression)
        //can only be used for interfaces with one method
        Operable lambdaOp = (double a, double b) -> {
            return a*b;
        };
        System.out.println(lambdaOp.operate(4.0, 7.8));

        System.out.println("+-----------------+");
        //can be simplified even more
        //You do not need the param types
        //You do not need the curly braces if the implementation is just one line
        Operable lambdaSimplerOp = (a, b) -> a/b;
        System.out.println(lambdaSimplerOp.operate(10.2,2.0));

        System.out.println("+-----------------+");

        Predicate<Integer> pred = i -> i<10;
        System.out.println(pred.test(5));
        System.out.println(pred.test(16));

        System.out.println("+---------------------------+");

        Printable print = (s) -> System.out.println(s);
        print.print("this was done with a lambda");

        //this is a method reference
        Printable print2 = System.out::println;
        print2.print("this was printed with lambda and a method reference");

        System.out.println("+-------------------+");

    }
}
