package question0935_knight_dialer;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(N)。
 *
 * 执行用时：57ms，击败39.91%。消耗内存：40.1MB，击败50.00%。
 */
public class Solution1 {
    private int[][] map = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

    private static final int MOD = 1000000007;

    private int[][] memo;

    public int knightDialer(int N) {
        if (N == 1) {
            return 10;
        }
        memo = new int[10][N];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 5) {
                result += knightDialer(i, N - 1);
                result %= MOD;
            }
        }
        return result;
    }

    private int knightDialer(int now, int N) {
        if (N == 0) {
            return 1;
        }
        if (memo[now][N] != 0) {
            return memo[now][N];
        }
        int result = 0;
        for (int next : map[now]) {
            result += knightDialer(next, N - 1);
            result %= MOD;
        }
        memo[now][N] = result;
        return result;
    }
}