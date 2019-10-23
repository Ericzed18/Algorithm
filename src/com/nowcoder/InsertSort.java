package com.nowcoder;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        for (int i = 1;i < arr.length;i++){
            for (int j = i-1; j>=0 && arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];

    }

    //使用对数期进行测试
    //1. 产生随机样本
    public static int[] generateRandomArray(int size,int value){
        int[] arr = new int[(int)((size+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((value+1)*Math.random())-(int)(value*Math.random());
        }
        return arr;
    }

    //2. 使用系统自带排序
    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }

    //3. 复制两个数组
    public static int[] copyArray(int[] arr){
        if(arr==null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i <res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //4. 判断排序后的数组是否相等
    public static boolean isEqual(int[] arr1,int[] arr2){
        if((arr1==null&&arr2!=null)||(arr1!=null&&arr2==null)){
            return false;
        }
        if(arr1==null&&arr2==null){
            return true;
        }
        if(arr1.length!=arr2.length){
            return false;
        }
        for (int i = 0;i<arr1.length;i++){
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    //5. 进行测试
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0;i<testTime;i++){
            int[] arr1 = generateRandomArray(size,value);
            int[] arr2 = copyArray(arr1);
//            int[] arr3 = copyArray(arr1);
            insertSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"Nice!":"Fucking fucked!");
    }
}
