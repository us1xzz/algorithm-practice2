package com.xzz.sort;

import java.util.Arrays;
//冒泡排序,加入flag可以减少不必要的遍历
public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {3,9,-1,10,20};
        int[] arr = new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i] =(int)(Math.random()*8000000);
        }

        long l = System.currentTimeMillis();
        BubbleSrot(arr);
        System.out.println(System.currentTimeMillis()-l);

        }


    public static int[] BubbleSrot(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                }
            }
            if (!flag){
                break;
            }else{
                flag =false; //重置flag，进行下次判断
            }
    }
        return arr;
}
}
