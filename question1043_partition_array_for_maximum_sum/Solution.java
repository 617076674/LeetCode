package question1043_partition_array_for_maximum_sum;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(n * k)，其中 n 为数组 arr 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：19ms，击败10.80%。消耗内存：41.5MB，击败5.49%。
 */
public class Solution {
    private int[][] maxes;

    private int n;

    private int[] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        maxes = new int[n][n];
        for (int i = 0; i < n; i++) {
            maxes[i][i] = arr[i];
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                maxes[i][j] = Math.max(maxes[i][j - 1], arr[j]);
            }
        }
        memo = new int[n];
        Arrays.fill(memo, -1);
        return maxSumAfterPartitioning(0, k);
    }

    private int maxSumAfterPartitioning(int left, int k) {
        if (left > n - 1) {
            return 0;
        }
        if (n - 1 == left) {
            return maxes[left][n - 1];
        }
        if (memo[left] != -1) {
            return memo[left];
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < Math.min(k, n - left); i++) {
            result = Math.max(result, maxSumAfterPartitioning(left + i + 1, k) + (i + 1) * maxes[left][left + i]);
        }
        memo[left] = result;
        return result;
    }
}