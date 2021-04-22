package io.github.alotool.tuts.algorithms.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinearSearchTest {

    @Test
    public void test_linear_search() {
        int[] arr = {99, 5, 50, 70, 10, 44, 9, 1, 3, 100};
        int x = 10;
        int idx = LinearSearch.search(arr, x);
        assertEquals(4, idx);
    }

    @Test
    public void test_linear_search_improve() {
        int[] arr = {99, 5, 50, 70, 10, 44, 9, 1, 3, 100};
        int x = 10;
        int idx = LinearSearch.searchImprove(arr, x);
        assertEquals(4, idx);
    }

}
