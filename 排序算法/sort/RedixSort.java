package com.eh.sort;

import java.util.Arrays;

public class RedixSort {
    public static void main(String[] args) {
        int[] ints = new int[]{24,74, 3, 34,14, 4, 34,3434,24,3435,324,544,234,124};
        //临时存储合并之后的数组
        redixSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void redixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        //求出数组中高度最大值的位数（最大值拥有最大位数）
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        int maxCount = (max + "").length();  //小技巧：将数转换成字符串，其长度即是其位数
        for (int i = 0; i < maxCount; i++) {
            //将arr数组中的每个数存在bucket二维数组中  一维数组bucketElementCount用于记录每个桶所存的数的个数
            for (int k = 0; k < arr.length; k++) {
                int value = arr[k] / (int)Math.pow(10, i) % 10;
                bucket[value][bucketElementCounts[value]] = arr[k];
                bucketElementCounts[value]++;
            }
            int index = 0;
            //多次循环后，最终将bucket中最后存的所有数按顺序赋值给arr
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int x = 0; x < bucketElementCounts[k]; x++) {
                        arr[index] = bucket[k][x];
                        index++;
                    }
                }
                //对k进行清0，用于下一循环
                bucketElementCounts[k] = 0;
            }
        }
    }
}
