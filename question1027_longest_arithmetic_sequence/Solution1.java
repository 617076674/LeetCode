package question1027_longest_arithmetic_sequence;

/**
 * 状态定义：
 * dp[i][j] 表示以 A[i] 结尾的公差为 j 的最长等差序列的长度。
 *
 * 初始化条件：
 * dp[i][j] = 1。
 *
 * 状态转移方程：
 * dp[i][j] = max(dp[k][j] + 1), k ∈ [0, i)。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为数组 A 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：132ms，击败58.78%。消耗内存：219.1MB，击败33.33%。
 */
public class Solution1 {
    public int longestArithSeqLength(int[] A) {
        int[][] dp = new int[A.length][20001];
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][A[i] - A[j] + 10000] = Math.max(Math.max(1, dp[j][A[i] - A[j] + 10000]) + 1, dp[i][A[i] - A[j] + 10000]);
                result = Math.max(dp[i][A[i] - A[j] + 10000], result);
            }
        }
        return result;
    }
}