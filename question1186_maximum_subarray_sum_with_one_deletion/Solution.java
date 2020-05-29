package question1186_maximum_subarray_sum_with_one_deletion;

/**
 * 状态定义：
 * dp[i][0] 表示以 arr[i]结尾的删除 0 个元素的子数组的最大值。
 * dp[i][1] 表示以 arr[i]结尾的删除 1 个元素的子数组的最大值。
 *
 * 初始化条件：
 * dp[0][0] = arr[0]。
 * dp[1][1] = arr[1]。
 *
 * 状态转移方程：
 * dp[i][0] = max(dp[i - 1][0] + arr[i], arr[i])。
 * dp[i][1] = arr[i] + max(dp[i - 1][1], dp[i - 2][0])。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 arr 的长度。
 *
 * 执行用时：13ms，击败19.16%。消耗内存：49.3MB，击败50.00%。
 */
public class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        dp[1][1] = arr[1];
        int result = Math.max(dp[0][0], dp[1][1]);
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(arr[i], arr[i] + dp[i - 1][0]);
            if (i >= 2) {
                dp[i][1] = arr[i] + Math.max(dp[i - 1][1], dp[i - 2][0]);
            }
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }
        return result;
    }
}