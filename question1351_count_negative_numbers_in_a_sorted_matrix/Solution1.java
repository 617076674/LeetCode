package question1351_count_negative_numbers_in_a_sorted_matrix;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(mn)，其中m是矩阵grid的行数，n是矩阵grid的列数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败64.54%。消耗内存：41.8MB，击败100.00%。
 */
public class Solution1 {
    public int countNegatives(int[][] grid) {
        int m;
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        int n;
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0 && grid[i][j] < 0 ; j--) {
                result++;
            }
        }
        return result;
    }
}