package question0311_sparse_matrix_multiplication;

/**
 * 简单的矩阵乘法运算。
 *
 * 时间复杂度是O(m1 * n2 * n1)，其中m1是矩阵A的行数，n2是矩阵B的列数，n1是矩阵A的列数。
 *
 * 执行用时：5ms，击败63.10%。消耗内存：37.7MB，击败100.00%。
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m1 = A.length, n1 = A[0].length, m2 = B.length, n2 = B[0].length;
        int[][] result = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}