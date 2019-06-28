package question0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 先计算要绕的圈数，再一圈一圈绕。
 *
 * 时间复杂度和空间复杂度均是O(p)，其中p是矩阵中的元素个数。
 *
 * 执行用时：1ms，击败91.31%。消耗内存：35.3MB，击败41.97%。
 */
public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return list;
        }
        boolean[][] visited = new boolean[m][n];
        int turn = Math.min(m, n) % 2 == 0 ? Math.min(m, n) / 2 : Math.min(m, n) / 2 + 1;
        for (int k = 0; k < turn; k++) {
            for (int i = k; i < n; i++) {
                if (!visited[k][i]) {
                    list.add(matrix[k][i]);
                    visited[k][i] = true;
                }
            }
            for (int i = k; i < m; i++) {
                if (!visited[i][n - 1 - k]) {
                    list.add(matrix[i][n - 1 - k]);
                    visited[i][n - 1 - k] = true;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (!visited[m - 1 - k][i]) {
                    list.add(matrix[m - 1 - k][i]);
                    visited[m - 1 - k][i] = true;
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                if (!visited[i][k]) {
                    list.add(matrix[i][k]);
                    visited[i][k] = true;
                }
            }
        }
        return list;
    }
}
