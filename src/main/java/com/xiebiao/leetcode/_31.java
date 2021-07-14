package com.xiebiao.leetcode;

import java.util.Arrays;

/**
 * @author bjxieb
 * @date 7/14/21
 **/
public class _31 {

    public static void main(String[] args) {
        _31 s = new _31();
        //int [] arr = new int[]{1, 2, 3};
        int[] arr = new int[]{1, 3, 2};
        s.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i] < nums[i + 1]) {
                index = i + 1;
            }
        }

        if (index == 0  ) {//没有更大的排列,升序排序
            if(nums[nums.length - 1] > nums[0]){
                swap(nums,0,nums.length-1);
            }else {
                quickSort(nums, 0, nums.length - 1);
            }

        } else {
            swap(nums,index-1,index);
        }

    }

    public void swap(int arr[], int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

    public void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivot = arr[(begin + end) / 2];
            int p = partition(arr, 0, arr.length - 1, pivot);
            quickSort(arr, begin, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    public int partition(int[] arr, int begin, int end, int pivot) {

        while (begin < end) {
            while (arr[begin] < pivot) {
                begin++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (arr[begin] > arr[end]) {
                int temp = arr[end];
                arr[end] = arr[begin];
                arr[begin] = temp;
                begin++;
                end--;
            }
        }
        return begin;

    }

}
