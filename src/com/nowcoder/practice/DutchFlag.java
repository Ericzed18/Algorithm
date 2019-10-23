package com.nowcoder.practice;

public class DutchFlag {

    private static void partition(int[] arr, int L, int R, int num){
        int left = L-1;
        int right = R+1;
        while (L<right){
            if (arr[L]<num){
                swap(arr,++left,L++);
            }else if (arr[L]>num){
                swap(arr,--right,L);
            }else {
                L++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,3,1,5,7,8};
        partition(arr,0,arr.length-1,3);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
