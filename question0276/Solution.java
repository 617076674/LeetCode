package question0276;

/**
 * @author qianyihui
 * @date 2019-08-19
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i]:第i个栅栏的涂色方案数量。
 *
 * 状态转移：
 * 当i == 0时，dp[0] = k
 * 当i == 1时，dp[1] = k * k
 *
 * 当i > 1时，分成两种情况：
 * （1）位置i的颜色和位置i - 1的颜色不同，此时有(k - 1) * dp[i - 1]种涂色方案。
 * （2）位置i的颜色和位置i - 1的颜色相同，那么位置i的颜色必须与位置i - 2的颜色不同，此时有(k - 1) * dp[i - 2]种涂色方案。
 *
 * dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1)
 *
 * 在实际实现过程中，为了空间复杂度的优化，只需要用num1和num2两个变量保存dp[i - 2]和dp[i - 1]的值即可。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.7MB，击败100.00%。
 */
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int num1 = k, num2 = k * k;
        for (int i = 2; i < n; i++) {
            int num = (num1 + num2) * (k - 1);
            num1 = num2;
            num2 = num;
        }
        return num2;
    }
}
