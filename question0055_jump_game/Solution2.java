package question0055_jump_game;

/**
 * 贪心算法。
 *
 * 记录下能达到的最远距离。
 *
 * 执行用时：3ms，击败36.94%。消耗内存：41.6MB，击败12.50%。
 */
public class Solution2 {
    public boolean canJump(int[] nums) {
        int n = nums.length, maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxLen) {
                maxLen = Math.max(maxLen, i + nums[i]);
                if (maxLen >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}