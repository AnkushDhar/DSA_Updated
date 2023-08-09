package com.company.company;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
     static class Stack {
        Deque<Integer> stack = new LinkedList<>();
        public void push (int data) {
            stack.addLast(data);
        }
        public int pop () {
            return stack.removeLast();
        }
        public int peek () {
            return stack.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek = "+s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}