package question1252_cells_with_odd_values_in_a_matrix;

/**
 * 暴力破解法。
 *
 * 时间复杂度和空间复杂度均是O(nm)。
 *
 * 执行用时：2ms，击败52.80%。消耗内存：37.8MB，击败17.33%。
 */
public class Solution1 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] nums = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < m; j++) {
                nums[indices[i][0]][j]++;
            }
            for (int j = 0; j < n; j++) {
                nums[j][indices[i][1]]++;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((nums[i][j] & 1) == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}