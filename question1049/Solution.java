package question1049;

/**
 * 动态规划。（背包问题）
 *
 * 由于石头拿走还能放回去，因此我们可以简单地把所有石头分成两堆。
 * 假设所有石头的总重量为sum, 则问题转化为：如何使两堆石头总重量接近(sum / 2)？
 *
 * 即容量为sum / 2的背包里最多能放进多少重量的石头？
 *
 * 状态定义：
 * dp[i]:容量为i的背包所能装石头的最大重量。
 *
 * 状态转移：
 * dp[i] = max(dp[i], dp[i - stones[j]] + stones[i])，其中i >= stones[j]。
 *
 * 时间复杂度是O(n * m)，其中n为stones数组的长度，m为stones数组中所有石头的重量和。
 *
 * 执行用时：6ms，击败43.67%。消耗内存：35.3MB，击败100.00%。
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n;
        if (null == stones || (n = stones.length) == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int capacity = sum >> 1;
        int[] dp = new int[capacity + 1];   //dp[i]表示容量为i的背包所能装石头的最大重量
        for (int i = 0; i < n; i++) {
            for (int j = capacity; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - (dp[capacity] << 1);
    }
}
