package com.nowcoder.practice;

public class MergeSort {
    private static void mergeSort(int[] arr){
        if (arr == null||arr.length<2){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int L, int R) {
        if(L ==R){
            return;
        }
        int mid = (L+R)/2;
        mergeSort(arr,L,mid);
        mergeSort(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R-L+1];
        int i = 0;
        int left = L;
        int right = mid+1;
        while (left<=mid&&right<=R){
            help[i++] = arr[left]<arr[right]?arr[left++]:arr[right++];
        }
        while (left<=mid){
            help[i++] = arr[left++];
        }
        while (right<=R){
            help[i++] = arr[right++];
        }
        for (i = 0;i<help.length;i++){
            arr[L+i] = help[i];
        }
    }
}
