package io.github.alotool.tuts.algorithms.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void test_binary_search_recursive() {
        int[] arr = {2, 4, 9, 10, 11, 22, 24, 31, 48, 56, 76, 86};
        int left = 0;
        int right = arr.length - 1;
        int x = 10;
        int idx = BinarySearch.search(arr, x, left, right);
        assertEquals(3, idx);
    }

    @Test
    public void test_binary_search_iterative() {
        int[] arr = {2, 4, 9, 10, 11, 22, 24, 31, 48, 56, 76, 86};
        int x = 10;
        int idx = BinarySearch.search(arr, x);
        assertEquals(3, idx);
    }
}
