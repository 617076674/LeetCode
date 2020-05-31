package question1223_dice_roll_simulation;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：78ms，击败32.85%。消耗内存：42.8MB，击败100.00%。
 */
public class Solution1 {
    private int[][][] memo;

    private static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        memo = new int[n + 1][16][7];
        return dieSimulator(n, rollMax, 0, 0);
    }

    private int dieSimulator(int n, int[] rollMax, int len, int pre) {
        if (memo[n][len][pre] != 0) {
            return memo[n][len][pre];
        }
        int result = 0;
        if (n == 1) {
            for (int i = 0; i < 6; i++) {
                if (i + 1 != pre || (i + 1 == pre && rollMax[i] >= len + 1)) {
                    result++;
                }
            }
        } else {
            if (pre == 0) {
                for (int i = 0; i < 6; i++) {
                    result += dieSimulator(n - 1, rollMax, len + 1, i + 1);
                    result %= MOD;
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    if (pre == i + 1) {
                        if (rollMax[i] >= len + 1) {
                            result += dieSimulator(n - 1, rollMax, len + 1, i + 1);
                        }
                    } else {
                        result += dieSimulator(n - 1, rollMax, 1, i + 1);
                    }
                    result %= MOD;
                }
            }
        }
        memo[n][len][pre] = result;
        return result;
    }
}