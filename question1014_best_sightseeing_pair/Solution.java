package question1014_best_sightseeing_pair;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] = j 表示以 i 为第一个景点时，第二个最优的景点是 j。
 *
 * 初始化条件：
 * dp[n - 2] = n - 1，其中 n 为数组 A 的长度。
 *
 * 状态转移方程：
 * 如果 A[dp[i + 1]] - dp[i + 1] > A[i + 1] - i - 1，则有 dp[i] = dp[i + 1]。
 * 如果 A[dp[i + 1]] - dp[i + 1] <= A[i + 1] - i - 1，则有 dp[i] = i + 1。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：6ms，击败11.76%。消耗内存：49.4MB，击败100.00%。
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int n = A.length;
        int[] dp = new int[n - 1];
        dp[n - 2] = n - 1;
        int result = A[n - 2] + A[n - 1] - 1;
        for (int i = n - 3; i >= 0; i--) {
            if (A[dp[i + 1]] - dp[i + 1] > A[i + 1] - i - 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = i + 1;
            }
            result = Math.max(result, A[i] + A[dp[i]] + i - dp[i]);
        }
        return result;
    }
}