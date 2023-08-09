package com.company;
import java.util.HashMap;
public class Hashing {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // Size
        System.out.println(hm.size());
        // isEmpty
        System.out.println(hm.isEmpty());

        // Get O(1)
        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("Indonesia"));

        // containsKey O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonesia"));

        // Remove O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm);
        System.out.println(hm.size());
        System.out.println(hm.remove("Indonesia"));
        System.out.println(hm);
        System.out.println(hm.size());

        //clear
        // hm.clear();
        // System.out.println(hm);
        // System.out.println(hm.isEmpty());
    }
}
