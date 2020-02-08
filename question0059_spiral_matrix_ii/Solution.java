package question0059_spiral_matrix_ii;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败45.11%。消耗内存：35.2MB，击败49.02%。
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1, left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = num++; //当前层的上边界
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;   //当前层的右边界
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = num++;  //当前层的下边界
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = num++;    //当前层的左边界
                }
                left++;
            }
        }
        return result;
    }
}