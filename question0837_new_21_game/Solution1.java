package question0837_new_21_game;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(K)。
 *
 * 执行用时：4ms，击败97.26%。消耗内存：39.5MB，击败100.00%。
 */
public class Solution1 {
    private double[] memo;

    public double new21Game(int N, int K, int W) {
        memo = new double[K];
        return new21Game(N, K, W, 0);
    }

    private double new21Game(int N, int K, int W, int now) {
        if (now >= K) {
            if (now <= N) {
                return 1.0;
            }
            return 0.0;
        }
        if (memo[now] != 0.0) {
            return memo[now];
        }
        double result;
        if (now + 1 >= K) {
            if (now + W <= N) {
                result = 1.0;
            } else {
                result = 1.0 * (N - now) / W;
            }
        } else {
            result = new21Game(N, K, W, now + 1) * (W + 1) / W - new21Game(N, K, W, now + W + 1) / W;
        }
        memo[now] = result;
        return memo[now];
    }
}