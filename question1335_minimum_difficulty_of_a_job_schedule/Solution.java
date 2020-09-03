package question1335_minimum_difficulty_of_a_job_schedule;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(d * n ^ 2)，其中 n 为 任务数量。空间复杂度是 O(nd + n ^ 2)。
 *
 * 执行用时：19ms，击败20.39%。消耗呢ICU怒：39.8MB，击败11.76%。
 */
public class Solution {
    private int[][] memo;

    private int[][] maxes;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        memo = new int[n][d + 1];
        maxes = new int[n][n];
        for (int i = 0; i < n; i++) {
            maxes[i][i] = jobDifficulty[i];
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                maxes[i][j] = Math.max(maxes[i + 1][j], jobDifficulty[i]);
            }
        }
        int result = minDifficulty(jobDifficulty, n - 1, d);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // 在 d 天时间内完成 [left, right] 范围内的任务的最小难度
    private int minDifficulty(int[] jobDifficulty, int right, int d) {
        if (d == 0) {
            return right >= 0 ? Integer.MAX_VALUE : 0;
        }
        if (d > right + 1) {
            return Integer.MAX_VALUE;
        }
        if (0 == right) {
            return d == 1 ? jobDifficulty[0] : Integer.MAX_VALUE;
        }
        if (memo[right][d] != 0) {
            return memo[right][d];
        }
        // 最后一天完成 i 件任务
        // d - 1 <= right - left + 1 - i
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= right + 2 - d; i++) {
            int tmp = minDifficulty(jobDifficulty, right - i, d - 1);
            if (tmp != Integer.MAX_VALUE) {
                result = Math.min(result, tmp + maxes[right - i + 1][right]);
            }
        }
        memo[right][d] = result;
        return result;
    }
}