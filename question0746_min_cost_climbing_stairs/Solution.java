package question0746_min_cost_climbing_stairs;

/**
 * 动态规划
 *
 * 状态定义：dp[i]    从数组索引i开始爬阶梯所需的最小花费
 *
 * 状态转移：
 *
 * 如果i == n - 1, dp[i] = cost[i]
 *
 * 如果i == n - 2, dp[i] = min(cost[i], cost[i + 1])
 *
 * 如果i == n - 3, dp[i] = min(cost[i] + dp[i + 1], cost[i + 1]
 * 这种情况对应于[1, 0, 1]的情况，只需走0即可，无需再走后面的1，因为走0已经能一步越过1到达终点
 *
 * 否则，dp[i - 1] = min(dp[i + 1] + cost[i], dp[i + 2] + cost[i])
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为cost数组的长度。
 *
 * 执行用时：4ms，击败41.70%。消耗内存36MB，击败94.61%。
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[n - 1] = cost[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (i == n - 2) {
                dp[i] = Math.min(dp[i + 1], cost[i]);
            } else if (i == n - 3) {
                dp[i] = Math.min(cost[i] + dp[i + 1], cost[i + 1]);
            } else {
                dp[i] = Math.min(cost[i] + dp[i + 1], cost[i + 1] + dp[i + 2]);
            }
        }
        return dp[0];
    }

}
