package com.company.company;
import java.util.*;
public class ReverseArray {
    public static void printRevArray(int [] array){
        int f = 0;
        int l = array.length-1;
        while(f<l){
            int temp = array[l];
            array[l] = array[f];
            array[f] = temp;

            f = f + 1;
            l = l - 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array Size: ");
        int n = sc.nextInt();
        int [] array = new int[n];
        System.out.println("Enter Array Elements: ");
        for (int i=0; i< array.length; i++){
            array[i] = sc.nextInt();
        }
        printRevArray(array);
        System.out.println("Reversed Array: ");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
