package com.nowcoder;

public class SelectSort {
    public static void selectSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1;j<arr.length;j++){
//                if (arr[minIndex]>arr[j]){
//                    minIndex = j;
//                }推荐使用三目运算符
                minIndex = arr[j]<arr[minIndex] ? j : minIndex;
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
