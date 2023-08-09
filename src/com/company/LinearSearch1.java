package com.company;
import java.util.*;
public class LinearSearch1 {
    public static int LinearS1(String [] menu, String key){
        for (int i=0; i< menu.length; i++){
            if(menu[i].equalsIgnoreCase(key)){
                return i;
            }
        }
        return -1;
    }

    public static void position(String [] menu, int x){
        for (int i=0; i<menu.length; i++) {
            if (i == x) {
                System.out.println(menu[i]);
            }
            else if(x> menu.length){
                System.out.println("Position not defined");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array Size: ");
        int n = sc.nextInt();

        String [] menu = new String[n];
        System.out.println("Enter "+(n-1)+" Elements: ");
        for (int i=0; i<menu.length; i++){
            menu[i] = sc.nextLine();
        }
        for (String value : menu) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.print("Food Item: ");
        String s = sc.nextLine();

        int idx = LinearS1(menu, s);
        if(idx == -1){
            System.out.println("Not Found");
        }else{
            System.out.println("Found at position "+idx);
        }

        System.out.print("Position: ");
        int x = sc.nextInt();
        position(menu, x);
    }
}
