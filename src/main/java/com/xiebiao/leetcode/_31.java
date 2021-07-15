package com.xiebiao.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author bjxieb
 * @date 7/14/21
 **/
public class _31 {

    public static void main(String[] args) {
        _31 s = new _31();
        //int [] arr = new int[]{1, 2, 3};
        int[] arr = new int[]{2, 3, 1};
        s.nextPermutation(arr);
        // s.reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] arr) {
        //TODO

    }

    public void reverse(int[] arr, int start) {
        int left = start;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }

    }

    public void swap(int arr[], int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

}
