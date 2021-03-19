package com.revature.testing;

import java.util.HashMap;

/**
 * Figuring out a way to solve
 * https://www.hackerrank.com/contests/210119-java-enterprise-hr4/challenges/merge-list/problem
 * with help from Brandon.
 * This solution works, but is too slow for large numbers
 */
public class CombinationsDriver {
    
    public static void main(String[] args) {
        // System.out.println(solve(15, 15));
        System.out.println(numOfWays(59, 67));
        
    }

    public static HashMap<Integer[], Integer> map = new HashMap<>();

    static int solve(int n, int m) {
        return shazbot(n, m);
    }

    static int shazbot(int i, int j){
        Integer[] key = {i, j};
        Integer[] reverseKey = {j, i};
        if (i == 1 || j == 1){
            map.put(key, i + j);
            return i + j;
        }
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (map.containsKey(reverseKey)) {
            return map.get(reverseKey);
        }
        int value = shazbot(i - 1, j) + shazbot(i, j - 1);
        map.put(key, value);
        return value;
    }

    // Solution from https://www.geeksforgeeks.org/number-ways-merge-two-arrays-retaining-order/

    // function to find the binomial  
    // coefficient 
    static int binomialCoeff(int n, int k) 
    { 
        int C[] = new int[k + 1]; 
        // memset(C, 0, sizeof(C)); 
      
        C[0] = 1; // nC0 is 1 
      
        for (int i = 1; i <= n; i++) { 
      
            // Compute next row of pascal  
            // triangle using the previous 
            // row 
            for (int j = Math.min(i, k); 
                               j > 0; j--) 
                C[j] = C[j] + C[j - 1]; 
        } 
          
        return C[k]; 
    } 
      
    // function to find number of ways  
    // to merge two array such that their  
    // order in merged array is same 
    static int numOfWays(int n, int m) 
    { 
        return binomialCoeff(m + n, m); 
    } 
}
