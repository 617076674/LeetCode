package question0566_reshape_the_matrix;

/**
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为nums数组的行数，n为nums数组的列数。
 *
 * 执行用时：2ms，击败98.53%。消耗内存：39.5MB，击败96.54%。
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m;
        if (null == nums || (m = nums.length) == 0) {
            return nums;
        }
        int n;
        if (null == nums || (n = nums[0].length) == 0) {
            return nums;
        }
        if (m * n != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int indexR = 0, indexC = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[indexR][indexC++] = nums[i][j];
                if (indexC == c) {
                    indexR++;
                    indexC = 0;
                }
            }
        }
        return result;
    }
}
