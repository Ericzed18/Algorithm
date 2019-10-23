package com.nowcoder.practice;

public class SmallSum {
    private static int smallSum(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return smallSum(arr,0,arr.length-1);
    }

    private static int smallSum(int[] arr, int L, int R) {
        if(L == R){
            return 0;
        }
        int mid = (L+R)/2;
        return smallSum(arr,L,mid)
                +smallSum(arr,mid+1,R)
                +merge(arr,L,mid,R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R-L+1];
        int i = 0;
        int res = 0;
        int left = L;
        int right = mid + 1;
        while (left<=mid&&right<=R){
            res += arr[left]<arr[right]?(R-right+1)*arr[left]:0;
            help[i++] = arr[left]<arr[right]?arr[left++]:arr[right++];
        }
        while (left<=mid){
            help[i++] = arr[left++];
        }
        while (right<=R){
            help[i++] = arr[right++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }
        return res;
    }
}
