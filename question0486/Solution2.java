package question0486;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为nums数组的长度。
 *
 * 执行用时：2ms，击败55.19%。消耗内存：35.3MB，击败66.23%。
 */
public class Solution2 {
    //sums[i]表示nums数组中[0, i - 1]范围内元素总和，那么sum[i] - sum[j]代表nums数组中[j, i - 1]范围内的元素和
    private int[] sums;

    private int[][] dp;

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        dp = new int[n][n];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int first = maxScoreOfFirst(nums, 0, n - 1);
        int second = sums[n] - first;
        if (first >= second) {
            return true;
        }
        return false;
    }

    /**
     * 对于nums数组中[left, right]范围内的元素，先取者能取到的最大分数
     */
    private int maxScoreOfFirst(int[] nums, int left, int right) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left == right) {
            return nums[left];
        }
        int sum = sums[right + 1] - sums[left];
        dp[left][right] = Math.max(sum - maxScoreOfFirst(nums, left + 1, right), sum - maxScoreOfFirst(nums, left, right - 1));
        return dp[left][right];
    }
}
