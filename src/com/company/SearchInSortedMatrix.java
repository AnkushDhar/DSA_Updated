package com.company.company;

public class SearchInSortedMatrix {
    public static boolean staircaseSearch (int [][] matrix, int key) {
        int row = 0, col = matrix[0].length-1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                return true;
            } else if (key < matrix[row][col]) {
                col = col-1;
            }
            else {
                row = row + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},
                           {10,11,16,20},
                           {23,30,34,60}};
        int key = 3;
        System.out.println(staircaseSearch(matrix, key));
    }
}
