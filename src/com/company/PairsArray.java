package com.company;
import java.util.Scanner;
public class PairsArray {
    public static void arrayPair(int [] array){
        int tp = 0;
        for (int i=0; i<array.length; i++){
            int curr = array[i];
            for(int j = i+1; j<array.length; j++){
                System.out.print("("+curr+", "+array[j]+")");
                tp = tp + 1;
            }
            System.out.println();
        }
        System.out.println("Total Pairs: "+tp);
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
        arrayPair(array);
    }
}
