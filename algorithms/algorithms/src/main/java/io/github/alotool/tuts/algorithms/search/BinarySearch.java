package io.github.alotool.tuts.algorithms.search;

public class BinarySearch {

    /**
     * Recursive implementation of Binary Search
     *
     * @param arr   mảng
     * @param x     phần tử cần tìm kiếm
     * @param left  left
     * @param right right
     * @return trả về vị trí tìm thấy, nếu không tìm thấy thì trả về -1
     */
    public static int search(int[] arr, int x, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return search(arr, x, left, (mid - 1));
            }
            return search(arr, x, (mid + 1), right);
        }
        return -1;
    }

    /**
     * Iterative implementation of Binary Search
     *
     * @param arr mảng
     * @param x   phần tử cần tìm kiếm
     * @return trả về vị trí tìm thấy, nếu không tìm thấy thì trả về -1
     */
    public static int search(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
