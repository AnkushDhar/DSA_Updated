package com.company.company;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid (String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') { // opening
                s.push(ch);
            } else {
                // closing
                if (s.isEmpty())
                    return false;
                if ((s.peek() == '(' && ch == ')')
                    || (s.peek() == '{' && ch == '}')
                    || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else
                    return false;
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // "({})[]" -> true
        System.out.println(isValid(str));
    }
}
