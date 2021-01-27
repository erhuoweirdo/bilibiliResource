package com.eh.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,1,98};
        selectSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minindex = j;
                }
            }
            if (i != minindex) {
                arr[minindex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
