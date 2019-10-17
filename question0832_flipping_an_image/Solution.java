package question0832_flipping_an_image;

/**
 * 水平翻转的同时实现反转。
 *
 * 时间复杂度是O(m * n)，其中m是矩阵A的行数，n是矩阵A的列数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败95.63%。消耗内存：36.8MB，击败99.21%。
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int m;
        if (A == null || (m = A.length) == 0) {
            return A;
        }
        int n;
        if (A[0] == null || (n = A[0].length) == 0) {
            return A;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < ((n + 1) >> 1); j++) {
                int tmp = A[i][j];
                A[i][j] = 1 - A[i][n - j - 1];
                A[i][n - j - 1] = 1 - tmp;
            }
        }
        return A;
    }
}
