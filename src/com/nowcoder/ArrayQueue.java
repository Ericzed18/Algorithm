package com.nowcoder;

public class ArrayQueue {
    private Integer[] arr;
    private Integer size;
    private Integer start;
    private Integer end;

    public ArrayQueue(int initSize){
        if (initSize<0){
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    public Integer peek(){
        if (size==0){
            return null;
        }
        return arr[start];
    }

    public void push(int obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[end] = obj;
        end = end == arr.length-1 ? 0 : end+1;
        size++;
    }

    public Integer poll(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        int temp = start;
        start = start == arr.length-1 ? 0 : start+1;
        return arr[temp];
    }
}
