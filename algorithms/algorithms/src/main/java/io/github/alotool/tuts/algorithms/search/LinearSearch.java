package io.github.alotool.tuts.algorithms.search;

public class LinearSearch {

    /**
     * @param arr mảng
     * @param x   phần tử cần tìm kiếm
     * @return trả về vị trí tìm thấy, nếu không tìm thấy thì trả về -1
     */
    public static int search(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int searchImprove(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] == x) {
                return left;
            }
            if (arr[right] == x) {
                return right;
            }
            left++;
            right--;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {99, 5, 50, 70, 10, 44, 9, 1, 3, 100};
        int x = 10;

        int idx1 = search(arr, x);
        System.out.printf("\nElement is present at index=%d", idx1);

        int idx2 = searchImprove(arr, x);
        System.out.printf("\nElement is present at index=%d", idx2);
    }
}
