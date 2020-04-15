package question0542_01_matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广搜。
 *
 * 时间复杂度和空间复杂度均是O(m * n)。
 *
 * 执行用时：18ms，击败58.44%。消耗内存：42.1MB，击败100.00%。
 */
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return new int[0][0];
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return new int[0][0];
        }
        int[][] result = new int[m][n], directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = -1;
                    queue.add(i * n + j);
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int now = queue.poll(), nowX = now / n, nowY = now % n;
                result[nowX][nowY] = distance;
                for (int j = 0; j < 4; j++) {
                    int newX = nowX + directions[j][0], newY = nowY + directions[j][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] != -1) {
                        matrix[newX][newY] = -1;
                        queue.add(newX * n + newY);
                    }
                }
            }
            distance++;
        }
        return result;
    }
}