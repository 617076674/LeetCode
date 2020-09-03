package question1326_minimum_number_of_taps_to_open_to_water_a_garden;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 时间复杂度是 O(n ^ 2)。空间复杂度是 O(1)。
 *
 * 执行用时：9ms，击败51.30%。消耗内存：39.8MB，击败83.67%。
 */
public class Solution1 {
    public int minTaps(int n, int[] ranges) {
        // lefts[i] 表示右边界为 i，左边界为 lefts[i] 的一个区间
        int[] lefts = new int[n + 1];
        Arrays.fill(lefts, n);
        for (int i = 0; i < n + 1; i++) {
            int left = Math.max(i - ranges[i], 0);
            int right = Math.min(i + ranges[i], n);
            lefts[right] = Math.min(lefts[right], left);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            // [lefts[i], i] 已经被覆盖，而 dp[i] 表示 [0, i] 已经被覆盖
            // 要确保 [0, lefts[i]]被覆盖，需要遍历 j ∈ [lefts[i], i)
            for (int j = lefts[i]; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}