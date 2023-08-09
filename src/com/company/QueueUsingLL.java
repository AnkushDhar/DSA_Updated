package com.company.company;

public class QueueUsingLL {
    static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Queue {
        static Node head = null;
        static Node tail = null;
        public static boolean isEmpty () {
            return head == null && tail == null;
        }
        public static void add (int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public static int remove () {
            if (isEmpty()) {
                return -1;
            }
            int front = head.data;
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
//        Queue q = new Queue();
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);

        while (!Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
