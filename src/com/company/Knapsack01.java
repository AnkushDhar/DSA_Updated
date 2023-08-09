package com.company.company;
import java.util.*;
public class Knapsack01 {
    public static int knapsackRecursion(int [] val, int [] wt, int w, int n){
        if(w == 0 || n == 0){
            return 0;
        }
        if(wt[n-1]<= w){
            int ans1 = val[n-1]+knapsackRecursion(val, wt, w-wt[n-1], n-1);
            int ans2 = knapsackRecursion(val, wt, w, n-1);
            return Math.max(ans1, ans2);
        } else {
            return knapsackRecursion(val, wt, w, n-1);
        }
    }
    public static int knapsackMemoization(int [] val, int [] wt, int w, int n, int[][] dp){
        if(w == 0 || n == 0){
            return 0;
        }
        if (dp[n][w] != -1){
            return dp[n][w];
        }
        if(wt[n-1]<= w){
            int ans1 = val[n-1]+knapsackMemoization(val, wt, w-wt[n-1], n-1, dp);
            int ans2 = knapsackMemoization(val, wt, w, n-1, dp);
            dp[n][w] = Math.max(ans1, ans2);
        } else {
            dp[n][w] = knapsackMemoization(val, wt, w, n-1, dp);
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            wt[j] = sc.nextInt();
        }
        int w = sc.nextInt();
        int [] [] dp = new int[val.length+1][w+1];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackRecursion(val, wt, w, val.length));
        System.out.println(knapsackMemoization(val, wt, w, val.length, dp));
    }
}
