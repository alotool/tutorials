package io.github.alotool.tuts.algorithms.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BruteForceTest {

    @Test
    public void test_bruteforce_search() {
        String source = "ABCDACEFABDFCAHTABHKARYLAB";
        String x = "AB";
        int count = BruteForce.search(source.toCharArray(), x.toCharArray());
        assertEquals(4, count);
    }
}
