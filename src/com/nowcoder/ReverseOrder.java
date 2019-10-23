package com.nowcoder;

public class ReverseOrder {
    private static void reverseOrder(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        sortProcess(arr,0,arr.length-1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if(L == R){
            return;
        }
        int mid = (L + R) / 2;
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while (p1<=mid&&p2<=R){
            if(arr[p1]>arr[p2]){
                System.out.println(arr[p1]+" "+arr[p2]);
                help[i++] = arr[p1++];
            }else {
                help[i++] = arr[p2++];
            }
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        for (i = 0;i<help.length;i++){
            arr[L+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,5};
        reverseOrder(a);
    }
}
