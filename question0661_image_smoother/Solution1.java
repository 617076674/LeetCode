package question0661_image_smoother;

/**
 * 非原地修改。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为矩阵M的行数，n为矩阵M的列数。
 *
 * 执行用时：14ms，击败59.53%。消耗内存：52.1MB，击败80.58%。
 */
public class Solution1 {
    public int[][] imageSmoother(int[][] M) {
        int m;
        if (null == M || (m = M.length) == 0) {
            return null;
        }
        int n;
        if (null == M[0] || (n = M[0].length) == 0) {
            return null;
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = M[i][j], count = 1;
                for (int k = 0; k < 8; k++) {
                    int newI = i + directions[k][0], newJ = j + directions[k][1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        sum += M[newI][newJ];
                        count++;
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
