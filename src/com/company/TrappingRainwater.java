package com.company;
import java.util.*;
public class TrappingRainwater {
    public static int trapperRainwater(int [] height){
        int [] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i=1; i< height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        int [] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i= height.length-2; i>= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int trappedWater = 0;
        for (int i=0; i< height.length; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int [] height = new int[h];
        for (int i=0; i< height.length; i++){
            height[i] = sc.nextInt();
        }
        System.out.println(trapperRainwater(height));
    }
}
