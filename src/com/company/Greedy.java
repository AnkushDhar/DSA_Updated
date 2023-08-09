package com.company.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] start = new int[n];
        int [] end = new int[n];
        for (int i=0; i<n; i++){
            start[i] = sc.nextInt();
        }
        for (int j=0; j<n; j++){
            end[j] = sc.nextInt();
        }
        int maxAct;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i=0; i< end.length; i++){
            if (start[i] >= lastEnd){
                maxAct ++;
                ans.add(i);
                lastEnd=end[i];
            }
        }
        System.out.println(maxAct);
        for (Integer an : ans) {
            System.out.print("A" + an + " ");
        }
        System.out.println();
    }
}
