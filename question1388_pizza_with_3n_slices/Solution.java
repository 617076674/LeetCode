package question1388_pizza_with_3n_slices;

import java.util.Arrays;

/**
 * 问题转化：给一个长度为 3n 的环状序列，你可以在其中选择 n 个数，并且任意两个数不能相邻，求这 n 个数的最大值。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为slices数组的长度。
 *
 * 执行用时：9ms，击败82.19%。消耗内存：40.4MB，击败100.00%。
 */
public class Solution {
    public int maxSizeSlices(int[] slices) {
        return Math.max(help(Arrays.copyOfRange(slices, 0, slices.length - 1)),
                help(Arrays.copyOfRange(slices, 1, slices.length)));
    }

    private int help(int[] slices) {
        int[][] dp = new int[slices.length + 1][(slices.length + 1) / 3 + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], (i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + slices[i - 1]);
            }
        }
        return dp[slices.length][(slices.length + 1) / 3];
    }
}