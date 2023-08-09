package com.company;

import java.util.Stack;

public class ReverseStack {
    public static void pushAtBottom (Stack<Integer> s2, int data) {
        if (s2.isEmpty()) {
            s2.push(data);
            return;
        }
        int top = s2.pop();
        pushAtBottom(s2, data);
        s2.push(top);
    }
    public static void reverseStack (Stack<Integer> s2) {
        if (s2.isEmpty()) {
            return;
        }
        int top = s2.pop();
        reverseStack(s2);
        pushAtBottom(s2, top);
    }
    public static void printStack (Stack<Integer> s2) {
        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);

        reverseStack(s2);
        printStack(s2);
    }
}
