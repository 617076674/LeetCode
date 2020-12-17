package question0887_super_egg_drop;

/**
 * 状态定义：
 * dp[i][j] 表示当前有 i 个鸡蛋，最多可以尝试扔 j 次，能确定最大的楼的高度。
 *
 * 初始化条件：
 * （1）当 i == 0 时，dp[0][j] = 0。
 * （2）当 j == 0 时，dp[i][0] = 0。
 *
 * 状态转移：
 * dp[i][j] = dp[i - 1][j - 1] + 1 + dp[i][j - 1]
 *
 * 时间复杂度和空间复杂度均是O(K * N)。
 *
 * 执行用时：3ms，击败78.27%。消耗内存：40.2MB，击败42.86%。
 */
public class Solution2 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int i = 1; i <= K; i++) {
                dp[i][m] = dp[i - 1][m - 1] + 1 + dp[i][m - 1];
            }
        }
        return m;
    }
}