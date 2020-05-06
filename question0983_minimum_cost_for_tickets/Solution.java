package question0983_minimum_cost_for_tickets;

/**
 * 动态规划。
 *
 * 时间复杂度是O(n ^ 2)，其中n为days数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：2ms，击败48.29%。消耗内存：37.6MB，击败100.00%。
 */
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        dp[days.length - 1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = days.length - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + costs[0];
            int tmp = i;
            while (tmp < days.length && days[tmp] - days[i] < 7) {
                tmp++;
            }
            if (tmp != i && tmp < days.length) {
                dp[i] = Math.min(dp[i], dp[tmp] + costs[1]);
            } else {
                dp[i] = Math.min(dp[i], costs[1]);
            }
            tmp = i;
            while (tmp < days.length && days[tmp] - days[i] < 30) {
                tmp++;
            }
            if (tmp != i && tmp < days.length) {
                dp[i] = Math.min(dp[i], dp[tmp] + costs[2]);
            } else {
                dp[i] = Math.min(dp[i], costs[2]);
            }
        }
        return dp[0];
    }
}