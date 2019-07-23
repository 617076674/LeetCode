package question0123;

/**
 * 在Solution2基础上的改进。
 *
 * 在第一笔交易前增加一笔虚拟的第0笔交易，其dp[0][j]均为0，这样就避免了对第一笔交易和第二笔交易的讨论。
 *
 * 同时，我们会发现Solution2中min的计算其实重复进行了，我们完全可以忽略内层的循环变量k的循环。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是prices数组的长度。
 *
 * 执行用时：4ms，击败88.56%。消耗内存：39.2MB，击败41.01%。
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        int result = 0, n = prices.length;
        if (0 == n) {
            return result;
        }
        int[][] dp = new int[3][n];
        for (int i = 1; i <= 2; i++) {
            dp[i][0] = 0;
            int min = prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
                min = Math.min(min, prices[j] - dp[i - 1][j - 1]);
            }
        }
        return dp[2][n - 1];
    }
}
