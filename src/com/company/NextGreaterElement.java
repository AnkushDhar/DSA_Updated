package com.company;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int [] nextGreaterElement (int [] arr) {
        Stack<Integer> s = new Stack<>();
        int [] nextGreater = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            // 1. While
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            // 2. if-else
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // 3. push in s
            s.push(i);
        }
        return nextGreater;
    }
    public static void main(String[] args) {
        int [] arr = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }
}
