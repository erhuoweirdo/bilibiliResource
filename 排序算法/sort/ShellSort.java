package com.eh.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] ints = new int[]{23,24,54,-324,2,1,1,1,98};
        shellSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static void shellSort(int[] arr) {
        //gap步长
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //插入式  间隔为gap的插入排序
                int insertIndex = i;
                int insertValue = arr[i];
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }
        }
    }
}
