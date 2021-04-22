package io.github.alotool.tuts.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * https://www.youtube.com/watch?v=nmhjrI-aW5o
     * https://www.geeksforgeeks.org/bubble-sort/?ref=lbp
     *
     * @param arr mang
     */
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < (n - 1); i++) {
            for (int j = 0; j < (n - 1) - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * https://www.geeksforgeeks.org/bubble-sort/?ref=lbp
     *
     * @param arr mang
     */
    public static void sortImprove(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < (n - 1); i++) {
            boolean swapped = false;
            for (int j = 0; j < (n - 1) - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
