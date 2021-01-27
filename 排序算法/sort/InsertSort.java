package com.eh.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,1,98};
        insertSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }

    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i;
            int insertValue = arr[i];
            while (insertIndex > 0 && insertValue < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            arr[insertIndex] = insertValue;
        }
    }
}
