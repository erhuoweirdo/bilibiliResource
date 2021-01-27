package com.eh.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23, -9, 78, 3, 34,3, 0, 34,23};
        //临时存储合并之后的数组
        int[] temp = new int[ints.length];
        mergeSort(ints, 0, ints.length - 1, temp);
        System.out.println(Arrays.toString(ints));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //递归的结束条件 如果left<right,说明可以继续分，则继续可以调用该函数，否则就不能分，就直接return
        if (left < right) {
            //mid：被分的两个部分的中间索引   用于之后合并两个部分时用
            int mid = (left + right) / 2;
            //将左边部分继续分
            mergeSort(arr, 0, mid, temp);
            //将右边部分继续分
            mergeSort(arr, mid + 1, right, temp);
            //代码运行到这里，递归已经调用完毕，开始回溯，从最开始的左右部分各一个元素开始回溯
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   //左边部分的最左侧索引
        int j = mid + 1; //右边部分的最左侧索引（当只有每个部分只有一个元素时，此时mid=left mid+1=right）
        int t = 0;//临时数组temp的索引，从0开始
        //将分开的两部分合并
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;i++;
            } else {
                temp[t] = arr[j];
                t++;j++;
            }
        }
        //如果左边部分有没有合并进去的，接着i继续合并
        while (i <= mid) {
            temp[t] = arr[i];
            t++;i++;
        }
        //如果右边部分有没有合并进去的，接着j继续合并
        while (j <= right) {
            temp[t] = arr[j];
            t++;j++;
        }
        //将临时数组temp的所存储的值，赋值给原数组arr
        t = 0;
        //原数组的索引需要从left开始，right结束
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;tempLeft++;
        }
    }

}
