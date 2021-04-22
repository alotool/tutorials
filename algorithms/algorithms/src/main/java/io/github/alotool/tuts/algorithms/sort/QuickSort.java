package io.github.alotool.tuts.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left - 1;
            int pivot = arr[right];
            for (int j = left; j < right; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int pi = i + 1;
            int temp = arr[pi];
            arr[pi] = arr[right];
            arr[right] = temp;

            sort(arr, left, (pi - 1));
            sort(arr, (pi + 1), right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
        System.out.println(Arrays.toString(arr));
    }
}
