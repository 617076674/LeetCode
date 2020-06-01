package question1227_airplane_seat_assignment_probability;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示有 i 位乘客时，第 i 位乘客坐在自己位置上的概率。
 *
 * 初始化条件：
 * dp[1] = 1.0。
 * dp[2] = dp[3] = 0.5。
 *
 * 状态转移方程：
 * dp[i] = 1 / i + dp[i - 1] / i + dp[i - 2] / i + ... + dp[1] / i = (1 + dp[i - 1] + ... + dp[1]) / i。
 * dp[i - 1] = (1 + dp[i - 2] + ... + dp[1]) / (i - 1)。
 * 可以推出 dp[i] = dp[i - 1]。
 *
 * 时间复杂度和空间复杂度均是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.3MB，击败25.00%。
 */
public class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1.0;
        }
        return 0.5;
    }
}