package com.company;
import java.util.*;
// sorted and rotated arrays
public class PairSum2 {
    public static boolean pairSum2(ArrayList<Integer> list, int target){
        int bp = -1;
        for (int i=0; i<list.size(); i++){
            if(list.get(i) > list.get(i+1)){
                bp = i;
                break;
            }
        }
        int lp = bp+1;
        int rp = bp;
        while ( lp != rp){
            int sum = list.get(lp)+list.get(rp);
            if (sum == target){
                return true;
            }
            if (sum < target){
                lp = (lp + 1)%list.size();
            } else {
                rp = (list.size()+rp-1)%list.size();
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 100;
        System.out.println(pairSum2(list, target));
    }
}
