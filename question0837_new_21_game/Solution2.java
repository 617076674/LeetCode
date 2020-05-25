package question0837_new_21_game;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示初始时爱丽丝手中有 i 分，最终结果不超过 N 的概率。
 *
 * 初始化条件：
 * 当 i >= K 时，如果 i <= N，则 dp[i] = 1.0；否则 dp[i] = 0.0。
 *
 * 状态转移方程：
 * dp[i] = (dp[i + 1] + dp[i + 2] + ... + dp[i + W]) / W。
 *
 * 当 i + 1 < K 时，有 dp[i + 1] = (dp[i + 2] + dp[i + 3] + ... + dp[i + W + 1]) / W，此时有
 * dp[i + 1] - dp[i] = (dp[i + W + 1] - dp[i + 1]) / W，移项可得
 * dp[i] = dp[i + 1] * (W + 1) / W - dp[i + W + 1] / W。
 *
 * 当 i + 1 == K 时，如果 i + W <= N，则 dp[i] = 1.0；否则 dp[i] = 1.0 * (N - i) / W。
 *
 * 时间复杂度是和空间复杂度均是 O(K + W)。
 *
 * 执行用时：4ms，击败97.26%。消耗内存：39.5MB，击败100.00%。
 */
public class Solution2 {
    public double new21Game(int N, int K, int W) {
        if (K - 1 + W <= N) {
            return 1.0;
        }
        if (K > N) {
            return 0.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i < K + W; i++) {
            if (i <= N) {
                dp[i] = 1.0;
            }
        }
        for (int i = K - 1; i >= 0; i--) {
            if (i + 1 >= K) {
                if (i + W <= N) {
                    dp[i] = 1.0;
                } else {
                    dp[i] = 1.0 * (N - i) / W;
                }
            } else {
                dp[i] = dp[i + 1] * (W + 1) / W - dp[i + W + 1] / W;
            }
        }
        return dp[0];
    }
}