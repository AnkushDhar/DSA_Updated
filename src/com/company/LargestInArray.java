package com.company;
import java.util.Scanner;
public class LargestInArray {
    public static void largest(int [] array, int x){
        for (int j : array) {
            if (x < j) {
                x = j;
            }
        }
        System.out.println("Largest: "+x);
    }
    public static void smallest(int [] array, int y){
        for (int k : array){
            if(y > k){
                y = k;
            }
        }
        System.out.println("Smallest: "+y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array Size: ");
        int n = sc.nextInt();
        int [] array = new int[n];
        System.out.print("Array Input: ");
        for (int i=0; i< array.length; i++){
            array[i] = sc.nextInt();
        }
        int x = Integer.MIN_VALUE;
        int y = Integer.MAX_VALUE;
        largest(array, x);
        smallest(array, y);
    }
}
