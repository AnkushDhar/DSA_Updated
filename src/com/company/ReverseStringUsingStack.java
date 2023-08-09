package com.company;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverseString (String str) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            st.push(String.valueOf(str.charAt(i)));
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx = idx + 1;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            sb.append(curr);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(reverseString(str));
    }
}
