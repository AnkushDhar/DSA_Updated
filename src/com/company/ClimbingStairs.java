package com.company.company;

import java.util.*;
import java.util.Arrays;
public class ClimbingStairs {
    public static int waysRecursion (int n){
        if(n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        return waysRecursion(n-1) + waysRecursion(n-2);
    }
    public static int waysMemoization (int n, int [] f){
        if(n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        if (f[n] != -1){
            return f[n];
        }
        f[n] = waysMemoization(n-1, f) + waysMemoization(n-2, f);
        return f[n];
    }
    public static int waysTabulation (int n){
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] f = new int[n+1];
        Arrays.fill(f, -1);
        System.out.println(waysRecursion(n));
        System.out.println(waysMemoization(n, f));
        System.out.println(waysTabulation(n));
    }
}
