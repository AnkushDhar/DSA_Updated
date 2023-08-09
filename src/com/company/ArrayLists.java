package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayLists {
    public static void swap (ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

        System.out.println(list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ArrayList - Java Collection Frame-work

        // Declaring ArrayList
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // Operations
        // 1. add Operation O(1)
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list1.add(1, 9); //O(n)

        System.out.println(list1);
        // ---------------------------------
        System.out.println(list1.size());
        // ---------------------------------
        // 2. get Operation O(1)
        int element = list1.get(2);
        System.out.println(element);

        // 3. remove Operation O(n)
        list1.remove(2);
        System.out.println(list1);

        // 4. set Operation O(n)
        list1.set(2, 10);
        System.out.println(list1);

        // 5. contains Operation O(n)
        System.out.println(list1.contains(3));
        System.out.println(list1.contains(5));

        // ----------------------------------
        for (int i=0; i< list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        for (int i= list1.size()-1; i>=0; i--){
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<list1.size(); i++){
//            if (list1.get(i) > max){
//                max = list1.get(i);
//            }
            max = Math.max(max, list1.get(i));
//            if (list1.get(i) < min){
//                min = list1.get(i);
//            }
            min = Math.min(min, list1.get(i));
        }
        System.out.println(max);
        System.out.println(min);

        // ----------------------------------

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        System.out.println(list);
        int idx1 = 1, idx2 = 3;
        swap(list, idx1, idx2);
    }
}
