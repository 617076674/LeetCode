package question0312_burst_balloons;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为数组 nums 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：12ms，击败22.24%。消耗内存：37.6MB，击败25.00%。
 */
public class Solution1 {
    private int[][] memo;

    private int n;

    public int maxCoins(int[] nums) {
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        memo = new int[n][n];
        return maxCoins(nums, 0, n - 1);
    }

    private int maxCoins(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        for (int i = left; i <= right; i++) {
            int leftNum = left - 1 >= 0 ? nums[left - 1] : 1, rightNum = right + 1 < n ? nums[right + 1] : 1;
            memo[left][right] = Math.max(memo[left][right], nums[i] * leftNum * rightNum
                    + maxCoins(nums, left, i - 1) + maxCoins(nums, i + 1, right));
        }
        return memo[left][right];
    }
}