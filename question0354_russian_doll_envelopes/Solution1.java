package question0354_russian_doll_envelopes;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示以第 i 个信封为最外层信封能组成的最多"俄罗斯套娃"信封数量。
 *
 * 初始化条件：
 * dp[i] = 0。
 *
 * 状态转移方程：
 * dp[i] = max(dp[j] + 1)，其中第 j 个信封能装进第 i 个信封里。
 *
 * 时间复杂度是O(n ^ 2)，其中 n 为信封数量。空间复杂度是O(n)。
 *
 * 执行用时：296ms，击败35.66%。消耗内存：40.7MB，击败100.00%。
 */
public class Solution1 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (envelop1, envelop2) -> {
            if (envelop1[0] == envelop2[0]) {
                return envelop1[1] - envelop2[1];
            }
            return envelop1[0] - envelop2[0];
        });
        int[] dp = new int[envelopes.length];
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}