package com.company;
import java.util.ArrayList;
// Sorting an Arraylist
import java.util.Collections;
public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        System.out.println(list);
        // Ascending
        Collections.sort(list);
        System.out.println(list);
        // Descending
        list.sort(Collections.reverseOrder());
        System.out.println(list);
    }
}
