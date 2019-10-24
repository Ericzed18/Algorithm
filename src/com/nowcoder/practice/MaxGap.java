package com.nowcoder.practice;

public class MaxGap {

    private static int maxGap(int[] arr){
        if (arr == null || arr.length<2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        if (max == min){
            return 0;
        }
        boolean[] hasNum = new boolean[arr.length+1];
        int[] maxs = new int[arr.length+1];
        int[] mins = new int[arr.length+1];
        int bid = 0;
        for (int i = 0; i < arr.length; i++) {
            bid = bucket(arr[i],arr.length,min,max);
            maxs[bid] = hasNum[bid]? Math.max(maxs[bid],arr[i]):arr[i];
            mins[bid] = hasNum[bid]? Math.min(mins[bid],arr[i]):arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int largest = maxs[0];
        for (int i = 1;i<=arr.length;i++){
            if (hasNum[i]){
                res = Math.max(res,mins[i]-largest);
                largest = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(int i, int len, int min, int max) {
        return (i-min)*len/(max-min);
    }
}
