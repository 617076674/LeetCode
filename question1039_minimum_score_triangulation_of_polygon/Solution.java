package question1039_minimum_score_triangulation_of_polygon;

/**
 * 状态定义：
 * dp[i][j] 表示 [i, j] 范围内的元素构成的凸多边形所能得到的三角分割的最低分。
 *
 * 初始化条件：
 * 当 j - i + 1 < 3 时，dp[i][j] = 0。
 *
 * 状态转移方程：第 0 个点和第 A.length - 1 个点是连在一跟边上的！
 * dp[i][j] = min(A[i] * A[j] * A[k] + dp[i][k] + dp[k][j]), k ∈ (i + 1, j - 1)。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为数组 A 的长度。
 *
 * 执行用时：5ms，击败53.77%。消耗内存：37.8MB，击败50.00%。
 */
public class Solution {
    public int minScoreTriangulation(int[] A) {
        int[][] dp = new int[A.length][A.length];
        for (int i = A.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < A.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (dp[i][j] == 0) {
                        dp[i][j] = A[i] * A[j] * A[k] + dp[i][k] + dp[k][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j], A[i] * A[j] * A[k] + dp[i][k] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][A.length - 1];
    }
}