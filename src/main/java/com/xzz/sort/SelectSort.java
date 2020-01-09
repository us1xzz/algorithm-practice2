package com.xzz.sort;

import java.util.Arrays;
//选择排序
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {45,13,56,8,4,3,7,8};
        int[] arr = new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i] =(int)(Math.random()*8000000);
        }

        long l = System.currentTimeMillis();
        selectSort(arr);
        System.out.println(System.currentTimeMillis()-l);


    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length ; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }

            }
            if (minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

    }
}
