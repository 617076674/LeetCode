package question0486_predict_the_winner;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为nums数组的长度。
 *
 * 执行用时：2ms，击败55.19%。消耗内存：35.3MB，击败66.23%。
 */
public class Solution2 {

    private int[] sums; // sums[i] 表示 nums 数组中 [0, i - 1] 范围内元素总和，那么 sums[i] - sums[j] 代表 nums 数组中 [j, i - 1] 范围内的元素和

    private int[][] memo;

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int first = maxScoreOfFirst(nums, 0, n - 1);
        return first >= sums[n] - first;
    }

    /**
     * 对于nums数组中[left, right]范围内的元素，先取者能取到的最大分数
     */
    private int maxScoreOfFirst(int[] nums, int left, int right) {
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        if (left == right) {
            return nums[left];
        }
        int sum = sums[right + 1] - sums[left];
        memo[left][right] = Math.max(sum - maxScoreOfFirst(nums, left + 1, right), sum - maxScoreOfFirst(nums, left, right - 1));
        return memo[left][right];
    }
}