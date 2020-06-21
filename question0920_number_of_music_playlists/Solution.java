package question0920_number_of_music_playlists;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示前 i 首歌里有 j 首不同的歌曲，这样的播放列表数量。
 *
 * 初始化条件：
 * （1）dp[0][0] = 1。
 * （2）dp[0][j] = 0, j ≠ 0。
 * （3）dp[i][0] = 0, i ≠ 0。
 *
 * 状态转移方程：
 * 如果第 i 首歌是未播放过的：dp[i][j] = dp[i - 1][j - 1] * (N - j + 1)。
 *
 * 如果第 i 首歌是播放过的：dp[i][j] = dp[i - 1][j] * max(j - K, 0)。
 *
 * 综上：dp[i][j] = dp[i - 1][j - 1] * (N - i + 1) + dp[i][j - 1] * max(i - K, 0)。
 *
 * 时间复杂度和空间复杂度均是 O(N * L)。
 *
 * 执行用时：12ms，击败17.65%。消耗内存：39.1MB，击败100.00%。
 */
public class Solution {
    public int numMusicPlaylists(int N, int L, int K) {
        long[][] dp = new long[L + 1][N + 1];
        int MOD = 1000000007;
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j - 1] * (N - j + 1) + dp[i - 1][j] * Math.max(j - K, 0);
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[L][N];
    }
}