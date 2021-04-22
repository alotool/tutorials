package io.github.alotool.tuts.algorithms.search;

public class BruteForce {

    /**
     * Thuật toán Brute Force
     * Tìm kiếm chuỗi con chứa trong chuỗi cha
     * Time complexity: O(nm)
     * Space complexity: O(nm)
     *
     * @param source chuỗi cha
     * @param x      chuỗi con
     * @return trả kết quả số lần đếm xuất hiện chuỗi con chứa trong chuỗi cha
     */
    public static int search(char[] source, char[] x) {
        int count = 0;          // Số lần đếm khi tìm thấy chuỗi con chứa trong chuỗi cha.
        int n = source.length;  // Độ dài chuỗi cha
        int m = x.length;       // Độ dài chuỗi con

        for (int i = 0; i <= (n - m); i++) {
            for (int j = 0; j < m && x[j] == source[i + j]; j++) {
                if (j >= m - 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
