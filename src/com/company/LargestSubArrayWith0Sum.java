package com.company;

import java.util.HashMap;

import java.util.HashMap;

public class LargestSubArrayWith0Sum {
    public static void main(String[] args) {
        int [] arr = {-1, 1, -1, 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        // (sum, idx)

        int sum = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                len = Math.max(len, i + 1);
            }
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(len);
    }
}

