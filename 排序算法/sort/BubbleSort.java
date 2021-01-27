package com.eh.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,1,98};
        bubbleSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
