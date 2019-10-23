package com.nowcoder.practice;

public class QuickSort {

    private static void quickSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L<R){
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int left = L - 1;
        int right = R;
        while (L<right){
            if (arr[L]<arr[R]){
                swap(arr,++left,L++);
            }else if (arr[L]>arr[R]){
                swap(arr,--right,L);
            }else {
                L++;
            }
        }
        swap(arr,right,R);
        return new int[] {left+1,right};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,3,1,5,7,8};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
