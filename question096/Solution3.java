package question096;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]：以[1, i]为节点组成的二叉搜索树的数目。
 *
 * 状态转移：
 * dp[1] = 1
 * dp[2] = 2
 *
 * 当i >= 3时，dp[i] = 2 * dp[i - 1] + sum(dp[j] * dp[i - j - 1], j ∈ [1, i - 1])
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(n)。
 *
 * 执行用时：0ms，击败100%。消耗内存：33.5MB，击败9.48%。
 */
public class Solution3 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * 2;
            for (int j = 1; j < i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
