package question0059;

/**
 * 和question0054一样的解法，只不过question0054是取数字，而本题是填数字。
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
                result[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }
        return result;
    }
}
