package com.xzz.sort;

import java.util.Arrays;
//插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {123, 34, 56, 78, 1};
        //创建随机数
//        int[] arr = new int[80000];
//        for (int i = 0; i <80000 ; i++) {
//            arr[i] =(int)(Math.random()*8000000);
//        }
        long l = System.currentTimeMillis();
        insertSort(arr);//大约需要时间640ms
        System.out.println(System.currentTimeMillis()-l);

    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数据
            int insertValue = arr[i];
            int insertIndex = i - 1;
            //insertIndex >= 保证数据下标不越界，insertValue < arr[insertIndex]待插入的数据还没有找到插入的位置
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //此地方优化性能上并没有较大的提升
            if (insertIndex+1 != i){
                arr[insertIndex + 1] = insertValue;
            }

            //System.out.println("第一趟插入的结果");
            //System.out.println(Arrays.toString(arr));

        }

    }
}
