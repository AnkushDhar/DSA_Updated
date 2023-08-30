package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] arr, int target) {
        int [] ans = new int[2];
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i:
                map.keySet()) {
            ans[0] = map.get(i);
            if (map.containsKey(target-i)) {
                ans[1] = map.get(target-i);
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
