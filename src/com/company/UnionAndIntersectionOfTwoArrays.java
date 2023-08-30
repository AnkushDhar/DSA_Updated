package com.company;

import java.util.HashSet;

public class UnionAndIntersectionOfTwoArrays {
    public static void main(String[] args) {
        int [] arr1 = {7, 3, 9};
        int [] arr2 = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        //Union
        for (int i : arr1) {
            set.add(i);
        }
        for (int i: arr2) {
            set.add(i);
        }
        System.out.println(set);
        System.out.println(set.size());

        set.clear();

        //Intersection
        for (int j : arr1) {
            set.add(j);
        }
//        int count = 0;
        for (int j : arr2) {
            if (set.contains(j)) {
//                count++;
                set1.add(j);
                set.remove(j);
            }
        }
        System.out.println(set1);
        System.out.println(set1.size());
//        System.out.println(count);
    }
}
