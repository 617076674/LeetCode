package question0960_delete_columns_to_make_sorted_iii;

import java.util.Arrays;

/**
 * 动态规划（最长上升子序列问题）。
 *
 * 状态定义：
 * dp[i] 表示以数组 A 中第 i 列结尾的满足题意的最长字符串长度。
 *
 * 初始化条件：
 * dp[0] = 1。
 *
 * 状态转移方程：
 * dp[i] = max(1, dp[j] + 1), j ∈ [0, i] 且数组 A 中各个字符串第 j 列的值均小于等于第 i 列的值。
 *
 * 时间复杂度是 O(m * (n ^ 2))，其中 m 为数组 A 的行数，n 为数组 A 的列数。空间复杂度是 O(n)。
 *
 * 执行用时：10ms，击败86.00%。消耗内存：39.5MB，击败50.00%。
 */
public class Solution {
    public int minDeletionSize(String[] A) {
        int[] dp = new int[A[0].length()];
        int remain = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                boolean considered = true;
                for (String s : A) {
                    if (s.charAt(i) < s.charAt(j)) {
                        considered = false;
                        break;
                    }
                }
                if (considered) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            remain = Math.max(remain, dp[i]);
        }
        return dp.length - remain;
    }
}