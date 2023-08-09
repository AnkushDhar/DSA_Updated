package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch {
    public static int binarySearch(int [] array, int x){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int mid = (start+end)/2;
            if(array[mid] == x){
                return mid;
            } if (array[mid] > x) {
                end = mid - 1;
            } else {
                start = mid +1;
            }
        }
        return -1;
    }
    public static void printArray(int [] array){
        System.out.println("Sorted Array is: ");
        for (int j : array){
            System.out.print(j+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array Size: ");
        int n = sc.nextInt();
        int [] array = new int[n];
        System.out.println("Enter Elements: ");
        for(int i=0; i< array.length; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        printArray(array);
        System.out.print("Key to Search: ");
        int x = sc.nextInt();
        int y = binarySearch(array, x);
        if (y == -1){
            System.out.println("Key Not Found");
        } else {
            System.out.println("Index of the Key in the Sorted Array: "+binarySearch(array, x));
        }
    }
}
