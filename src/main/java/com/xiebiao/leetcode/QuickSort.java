package com.xiebiao.leetcode;

import java.util.Arrays;

/**
 * 快排
 *
 * @author bjxieb
 * @date 7/13/21
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 1, 9};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{5, 2, 7, 1, 9};
        QuickSort.quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }


    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int p = partition(arr, begin, end);
            quickSort(arr, begin, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    public static void quickSort2(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivot = arr[(begin + end) / 2];
            int p = hoarePartition(arr, begin, end, pivot);
            quickSort2(arr, begin, p - 1);
            quickSort2(arr, p + 1, end);
        }
    }

    /**
     * 霍尔发明(C.A.R.Hoare)
     */
    private static int hoarePartition(int arr[], int left, int right, int pivot) {

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right++;
            }
            while (arr[left] > arr[right]) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }

        }
        return left;
    }

    /**
     * 选择最后一个元素作为pivot 使用双游标法:l表示小于pivot的最后一个元素的下标，r则相反
     */
    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int l = begin - 1;
        for (int r = begin; r < end; r++) {
            if (arr[r] <= pivot) {
                l++;
                int swapTemp = arr[l];
                arr[l] = arr[r];
                arr[r] = swapTemp;
            }
        }
        int swapTemp = arr[l + 1];
        arr[l + 1] = arr[end];
        arr[end] = swapTemp;
        return l + 1;
    }
}
