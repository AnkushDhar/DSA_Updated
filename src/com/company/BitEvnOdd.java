package com.company;
import java.util.*;
public class BitEvnOdd {
    public static void evnODD (int n) {
        int bitmask = 1;
        if ((n&1) == bitmask) {
            System.out.println("ODD");
        } else {
            System.out.println("Even");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        evnODD(n);
    }
}
