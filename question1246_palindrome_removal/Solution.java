package question1246_palindrome_removal;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示删除数组 arr 中 [i, j] 范围内的子数组，需要的最少操作次数。
 *
 * 初始化条件：
 * 当 i == j 时，dp[i][j] = 1。
 *
 * 状态转移方程：
 * dp[i][j] = min(dp[i][k] + dp[k + 1][j), k ∈ [i, j)。
 * 当 arr[i] == arr[j] 时，dp[i][j] = min(dp[i][j], dp[i + 1][j - 1])。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为数组 arr 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：46ms，击败36.25%。消耗内存：39.8MB，击败43.08%。
 */
public class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                if (gap == -1) {
                    dp[i][j] = 1;
                    if (arr[i] != arr[j]) {
                        dp[i][j]++;
                    }
                } else {
                    dp[i][j] = n;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                    if (arr[i] == arr[j]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}