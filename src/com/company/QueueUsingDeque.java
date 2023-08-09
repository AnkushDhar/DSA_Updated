package com.company.company;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {
    static class Queue {
        Deque<Integer> queue = new LinkedList<>();
        public void add (int data) {
            queue.addLast(data);
        }
        public int remove () {
            return queue.removeFirst();
        }
        public int peek () {
            return queue.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek = "+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
