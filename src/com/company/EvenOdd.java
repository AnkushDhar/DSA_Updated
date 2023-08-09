package com.company;

import java.util.Scanner;

public class EvenOdd {
    public static void chkEvenOdd (int n) {
        int bitmask = 1;
        if ((n&bitmask) == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        chkEvenOdd(n);
    }
}
