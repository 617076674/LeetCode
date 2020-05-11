package question0651_4_keys_keyboard;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示可以按键 i 次，屏幕上最多可以显示的字符 A 的数目。
 *
 * 初始化条件：
 * dp[0] = 0。
 *
 * 状态转移方程：
 * 要使得 dp[i] 的值最大，最后一次操作要么是 Key1，要么是 Key4，即从 dp[i - 1] 转移到 dp[i] 的操作要么是 Key1，要么是 Key4。
 *
 * dp[i] = max(dp[i - 1] + 1, dp[j - 2] * (i - j + 1)), j ∈ [2, i)。
 *
 * 时间复杂度是O(N ^ 2)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败90.23%。消耗内存：36.5MB，击败100.00%。
 */
public class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }
}