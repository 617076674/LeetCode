package question0361;

/**
 * @author qianyihui
 * @date 2019-08-20
 *
 * 暴力破解法。
 *
 * 时间复杂度是O(m * n * (m + n))，其中m为网络的行数，n为网络的列数。空间复杂度是O(1)。
 *
 * 执行用时：18ms，击败81.63%。消耗内存：51.6MB，击败100.00%。
 */
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int result = 0, m = grid.length;
        if (m == 0) {
            return result;
        }
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int tmpResult = 0, tmp = i;
                    while (tmp + 1 < m && grid[tmp + 1][j] != 'W') {
                        if (grid[tmp + 1][j] == 'E') {
                            tmpResult++;
                        }
                        tmp++;
                    }
                    tmp = i;
                    while (tmp - 1 >= 0 && grid[tmp - 1][j] != 'W') {
                        if (grid[tmp - 1][j] == 'E') {
                            tmpResult++;
                        }
                        tmp--;
                    }
                    tmp = j;
                    while (tmp + 1 < n && grid[i][tmp + 1] != 'W') {
                        if (grid[i][tmp + 1] == 'E') {
                            tmpResult++;
                        }
                        tmp++;
                    }
                    tmp = j;
                    while (tmp - 1 >= 0 && grid[i][tmp - 1] != 'W') {
                        if (grid[i][tmp - 1] == 'E') {
                            tmpResult++;
                        }
                        tmp--;
                    }
                    result = Math.max(result, tmpResult);
                }
            }
        }
        return result;
    }
}
