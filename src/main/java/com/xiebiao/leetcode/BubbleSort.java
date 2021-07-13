package com.xiebiao.leetcode;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author bjxieb
 * @date 2020/9/21
 **/
public class BubbleSort {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(sort(new int[]{29, 4, 3, 1})));
        System.out.println(Arrays.toString(sort2(new int[]{29, 4, 3, 1})));
        // System.out.println(Arrays.toString(sort(new int[]{5, 2, 7, 1})));
    }

    public static int[] sort(int[] arr) {
        int temp;
        System.out.println("init:" + Arrays.toString(arr));
        do {
            temp = arr[0];
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
                System.out.println("next round:" + Arrays.toString(arr));
            }
        } while (temp != arr[0]);//有交换
        return arr;
    }

    public static int[] sort2(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; ++j) {        //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数放到最后到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("next round:" + Arrays.toString(arr));
            if (!swapped) {
                break;//没有数据交换，数组已经有序，退出排序
            }
        }
        return arr;
    }
}
