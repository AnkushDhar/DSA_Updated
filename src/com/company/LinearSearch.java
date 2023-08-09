package com.company.company;
import java.util.Scanner;

public class LinearSearch {
    public static int linearS(int [] array, int key){
        for(int i=0; i< array.length; i++){
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array Size: ");
        int n = sc.nextInt();

        int [] array = new int [n];
        System.out.print("Enter "+n+" Numbers: ");
        for(int i=0; i<array.length; i++){
            array [i] = sc.nextInt();
        }

        System.out.print("Enter Number to Search: ");
        int key = sc.nextInt();

        int idx = linearS(array, key);
        if(idx == -1){
            System.out.println("Not Found");
        }else{
            System.out.println("Number Found at Position: "+idx);
        }
    }
}
