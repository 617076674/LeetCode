package question0045;

/**
 * 回溯法。
 *
 * 时间复杂度是O(2 ^ n)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    private int steps = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        jump(nums, 0, 0);
        return steps;
    }

    /**
     * 现在在索引index处，从索引0到索引index已经跳了tempSteps步，求跳到数组末尾的最少步数
     */
    private void jump(int[] nums, int index, int tempSteps) {
        if (index >= nums.length - 1) {
            if (index == nums.length - 1) {
                steps = Math.min(steps, tempSteps);
            }
            return;
        }
        for (int i = 1; i <= nums[index]; i++) {
            jump(nums, index + i, tempSteps + 1);
        }
    }
}
