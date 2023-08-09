package com.company;
import java.util.Scanner;
public class Arrays {
    public static void Update(int[] marks){
        for(int i=0; i< marks.length; i++){
            marks[i] = marks[i] + 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[3];
        for(int i=0; i< marks.length; i++){
            marks[i] = sc.nextInt();
        }
        Update(marks);
        for (int mark : marks) {
            System.out.println(mark);
        }
    }
}
