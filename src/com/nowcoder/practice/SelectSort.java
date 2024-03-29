package com.nowcoder.practice;

public class SelectSort {
    private static void selectSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        for (int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                minIndex = arr[minIndex]<arr[j]?minIndex:j;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
