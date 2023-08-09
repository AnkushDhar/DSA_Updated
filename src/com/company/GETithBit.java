package com.company;
import java.util.Scanner;
public class GETithBit {
    public static int getIthBit (int n, int i) {
        int bitmask = (1<<i);
        if ((n&bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        System.out.println(getIthBit(n, i));
    }
}
