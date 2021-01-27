package com.eh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
   public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //找一个小于等于target的最大数
        int[] arr = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            arr[i] = matrix[i][0];
        }
        int left = 0; int right = arr.length - 1;
        int index = -1;//要查找的值的下标索引
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target >= arr[mid]) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        for (int i = 0; i <= index; i++) { //遍历0-index的所有行
            int[] arr1 = matrix[i];
            left = 0; right = arr1.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target > arr1[mid]) {
                    left = mid + 1;
                } else if (target < arr1[mid]) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
