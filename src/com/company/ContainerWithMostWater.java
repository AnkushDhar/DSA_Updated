package com.company.company;
import java.util.*;
public class ContainerWithMostWater {
    public static int storeWaterBF (ArrayList<Integer>height){
        int maxWater = 0;
        for (int i=0; i< height.size(); i++){
            for (int j=i+1; j< height.size(); j++){
                int h = Math.min(height.get(i), height.get(j));
                int w = j - i;
                int currWater = h*w;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }
    public static int storeWater2P(ArrayList<Integer>height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;
        while (lp<rp){
            int h = Math.min(height.get(lp), height.get(rp));
            int w = rp - lp;
            int currWater = h*w;
            maxWater = Math.max(maxWater, currWater);
            if (height.get(lp) < height.get(rp)){
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storeWaterBF(height));
        System.out.println(storeWater2P(height));
    }
}
