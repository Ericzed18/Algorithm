package com.nowcoder;

public class MaxGap {

    private static int maxGap(int[] arr){
        if (arr == null || arr.length <2){
            return 0;
        }
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        if (max == min){
            return 0;
        }
        boolean[] hasNum = new boolean[len+1];
        int[] maxs = new int[len+1];
        int[] mins = new int[len+1];
        int bid = 0;
        for (int i = 0; i<len;i++){
            bid = bucket(arr[i],len,min,max);
            mins[bid] = hasNum[bid]? Math.min(mins[bid],arr[i]) : arr[i];
            maxs[bid] = hasNum[bid]? Math.max(maxs[bid],arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i<=len;i++){
            if(hasNum[i]){
                res = Math.max(res,mins[i]-lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(int i, int len, int min, int max) {
        return (int)((i-min)*len/(max-min));
    }
}
