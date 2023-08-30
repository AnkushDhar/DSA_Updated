package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static int [] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return new int[] {i, map.get(diff)};
            }
            map.put(arr[i], i);
        }
        return new int[] {0, 0};
    }
    public static void main(String[] args) {
        int [] arr = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
