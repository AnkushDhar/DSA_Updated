package com.company.company;
import java.util.*;
public class PrefixSum {
    public static void sums (int [] array){
        int sum;
        int max = Integer.MIN_VALUE;
        int [] prefix = new int[array.length];
        prefix[0] = array[0];
        for (int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i-1] + array[i];
        }
        System.out.print("Prefix Array: ");
        for (int j : prefix) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i=0; i< array.length; i++){
            for (int j=i; j< array.length; j++){
                sum = i == 0 ? prefix[j] :  prefix[j] - prefix[i-1];
                if (sum > max){
                    max = sum;
                }
            }
        }
        System.out.println("Max SubArray Sum: "+max);
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
        sums(arr);
    }
}
