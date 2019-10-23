package com.nowcoder;

public class HeapSort {
    private static void heapSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int size = arr.length-1;
        swap(arr,0,--size);
        while (size>0){
            heapify(arr,0,size);
        }
    }

    private static void heapify(int[] arr, int i, int size) {
        int left = i*2+1;
        while (left<size){
            int largest = arr[left] < arr[left+1]
                    ? left+1
                    :left;
            largest = arr[i] < arr[largest]
                    ? largest
                    :i;
            if (largest == i){
                break;
            }
            swap(arr,i,largest);
            i = largest;
            left = i*2+1;
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while (arr[i]>arr[(i-1)/2]){
            swap(arr,i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
