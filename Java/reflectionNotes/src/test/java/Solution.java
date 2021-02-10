import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static int solve(int n, int m) {
        System.out.println("Should be "+(n+m)+" choose "+n);
        System.out.println(n+", "+m);

        int chooseNminR = 1;

        int top = 1;

        for (int i = n+m; i > n; i--) {
            top *= i;
        }

        System.out.println("n!/r! is "+top);

        for (int i = 1; i <= m; i++) {
            chooseNminR *= i;
        }

        System.out.println("N-R is "+chooseNminR);

        return top/(chooseNminR);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(solve(5, 2));
    }
}
