package question1351_count_negative_numbers_in_a_sorted_matrix;

/**
 * 从矩阵grid左下角开始遍历。
 *
 * 时间复杂度是O(m + n)，其中m是矩阵grid的行数，n是矩阵grid的列数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：41.7MB，击败100.00%。
 */
public class Solution3 {
    public int countNegatives(int[][] grid) {
        int m;
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        int n;
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int result = 0, i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            while (j < n && grid[i][j] >= 0) {
                j++;
            }
            result += n - j;
            i--;
        }
        return result;
    }
}