package com.company.company;
import java.util.*;
// sorted arrays
public class PairSum1 {
    public static boolean pairSum1(ArrayList<Integer> list, int target){
        for (int i=0; i< list.size(); i++){
            for (int j=i+1; j< list.size(); j++){
                int sum = list.get(i)+ list.get(j);
                if (sum == target){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target){
                return true;
            }if (sum < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        int target = sc.nextInt();
        System.out.println(pairSum1(list, target));
        System.out.println(pairSum2(list, target));
    }
}
