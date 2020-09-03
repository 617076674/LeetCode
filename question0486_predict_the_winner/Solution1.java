package question0486_predict_the_winner;

/**
 * 递归。
 *
 * 时间复杂度是O(2 ^ n)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：63ms，击败10.74%。消耗内存：34.8MB，击败84.42%。
 */
public class Solution1 {

    private int[] sums; // sums[i] 表示 nums 数组中 [0, i - 1] 范围内元素总和，那么 sums[i] - sums[j] 代表 nums 数组中 [j, i - 1] 范围内的元素和

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
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
        if (left == right) {
            return nums[left];
        }
        int sum = sums[right + 1] - sums[left];
        return Math.max(sum - maxScoreOfFirst(nums, left + 1, right), sum - maxScoreOfFirst(nums, left, right - 1));
    }
}