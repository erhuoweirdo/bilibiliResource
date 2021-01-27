package com.eh.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23, -9, 78, 3, 34,3, 0, 34,23};
        quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            //递归调用函数结束
            return;
        }
        int l = left;
        int r = right;
        while (l < r) {
            //每次都以arr[left]为标准进行对比
            while (l < r && arr[r] >= arr[left]) r--;
            while (l < r && arr[l] <= arr[left]) l++;
            //两次循环后，最终是l==r  此时arr[r]一定小于等于arr[left]
            if (r == l) {
                //此时该循环就结束了
                int temp = arr[r];
                arr[r] = arr[left];
                arr[left] = temp;
            } else {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        //此时r == l  索引r左边的元素小于arr[r]  索引r右边的元素大于arr[r];
        //在分别对左右部分进行快排
        quickSort(arr, left, l - 1);
        quickSort(arr, r + 1, right);
    }

}
