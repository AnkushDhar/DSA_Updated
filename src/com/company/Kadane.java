package com.company;

import java.util.Scanner;

public class Kadane {
    public static void maxSum (int [] array){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int j : array) {
            sum = sum + j;
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println("Maximum SubArray Sum: "+maxSum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array Size: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter Array Elements: ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        maxSum(arr);
    }
}
