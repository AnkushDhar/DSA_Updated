package com.company.company;

public class StackUsingLinkedList {
    static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Stack1 {
        static Node head = null;
        public static boolean isEmpty () {
            return head == null;
        }

        // push
        public static void push (int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop
        public static int pop () {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public static int peek () {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack1.push(1);
        Stack1.push(2);
        Stack1.push(3);
        while (!Stack1.isEmpty()) {
            System.out.println(Stack1.peek());
            Stack1.pop();
        }
    }
}
