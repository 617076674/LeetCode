package question0887_super_egg_drop;

/**
 * 状态压缩。
 *
 * 时间复杂度是O(K * N)。空间复杂度是O(K)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.3MB，击败71.43%。
 */
public class Solution3 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[2][K + 1];
        int m = 0;
        while (dp[m % 2][K] < N) {
            m++;
            for (int i = 1; i <= K; i++) {
                dp[m % 2][i] = dp[1 - m % 2][i - 1] + 1 + dp[1 - m % 2][i];
            }
        }
        return m;
    }
}