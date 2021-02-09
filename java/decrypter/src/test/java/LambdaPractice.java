import java.util.Comparator;
import java.util.function.BiFunction;

public class LambdaPractice {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> areEven = (Integer a, Integer b) -> (a%2)+(b%2);

        System.out.println(areEven.apply(1, 3));

        Comparator<Double> less = (Double a, Double b) -> {
            if (a < b) return -1;
            return 0;
        };
    }
}
