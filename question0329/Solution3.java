package question0329;

import java.util.ArrayList;
import java.util.List;

/**
 * 拓扑排序。（剥洋葱法）
 *
 * 关键在于寻找拓扑排序的起点。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为矩阵的行数，n为矩阵的列数。
 *
 * 执行用时：57ms，击败14.08%。消耗内存：57.5MB，击败6.28%。
 */
public class Solution3 {
    public int longestIncreasingPath(int[][] matrix) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return 0;
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return 0;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] outdegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int newI = i + directions[k][0], newJ = j + directions[k][1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[i][j] < matrix[newI][newJ]) {
                        outdegree[i][j]++;
                    }
                }
            }
        }
        List<int[]> leaves = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (outdegree[i][j] == 0) {
                    leaves.add(new int[]{i, j});
                }
            }
        }
        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            List<int[]> newLeaves = new ArrayList<>();
            for (int[] node : leaves) {
                for (int k = 0; k < 4; k++) {
                    int newI = node[0] + directions[k][0], newJ = node[1] + directions[k][1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[node[0]][node[1]] > matrix[newI][newJ]) {
                        if (--outdegree[newI][newJ] == 0) {
                            newLeaves.add(new int[]{newI, newJ});
                        }
                    }
                }
            }
            leaves = newLeaves;
        }
        return height;
    }
}