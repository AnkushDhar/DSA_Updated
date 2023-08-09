package com.company.company;
import java.util.*;
public class SubArray {
    public static void printSubArray (int [] arr){
        int ts = 0;
        int sum;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j< arr.length; j++){
                sum = 0;
                for (int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                    sum = sum + arr[k];
                }
                ts = ts + 1;
                System.out.print("("+sum+")");
                if (maxSum < sum){
                    maxSum = sum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Maximum SubArray Sum: "+maxSum);
        System.out.println("Total SubArrays: "+ts);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        printSubArray(arr);
    }
}
