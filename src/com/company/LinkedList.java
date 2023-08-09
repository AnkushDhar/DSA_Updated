package com.company;
public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst (int data) {
        // Step:1 Create new Node
        Node newNone = new Node(data);
        size = size + 1;
        if (head == null){
            head = tail = newNone;
            return;
        }
        // Step:2 newNode next = head
        newNone.next = head;
        // Step:3 head = newNode
        head = newNone;
    }
    public void addLast (int data) {
        // Step:1 Create new Node
        Node newNode = new Node(data);
        size = size + 1;
        if (head == null){
            head = tail = newNode;
            return;
        }
        // Step:2 tail.next = newNode
        tail.next = newNode;
        // Step:3 tail = newNode
        tail = newNode;
    }
    public void printLinkedList () {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add (int idx, int data) {
        Node newNode = new Node(data);
        size = size + 1;
        Node temp = head;
        int i = 0;
        while (i < idx-1){
            temp = temp.next;
            i = i+1;
        }

        // i = idx - 1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst () {
        if (size == 0) {
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size = size - 1;
        return val;
    }
    public int removeLast () {
        if (size == 0) {
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size = size - 1;
        return val;
    }
    public int itrSearch (int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int helper (Node head, int key) {
        if (head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx+1;
    }
    public int recSearch (int key) {
        return helper(head, key);
    }
    public void reverse () {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String [] args) {
        LinkedList ll = new LinkedList();
        ll.printLinkedList();
        ll.addFirst(2);
        ll.printLinkedList();
        ll.addFirst(1);
        ll.printLinkedList();
        ll.addLast(3);
        ll.printLinkedList();
        ll.addLast(4);
        ll.printLinkedList();
        ll.add(2, 5);
        ll.printLinkedList();
        System.out.println(ll.size);
        System.out.println(ll.removeFirst());
        ll.printLinkedList();
        System.out.println(ll.size);
        System.out.println(ll.removeLast());
        ll.printLinkedList();
        System.out.println(ll.size);
        System.out.println(ll.itrSearch(3));
        System.out.println(ll.itrSearch(10));
        System.out.println(ll.recSearch(3));
        System.out.println(ll.recSearch(10));
        ll.reverse();
        ll.printLinkedList();
    }
}
