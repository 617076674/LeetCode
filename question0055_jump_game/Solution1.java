package question0055_jump_game;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i]:从第i处能否到达数组末尾
 *
 * 状态转移：
 * dp[i] = dp[i + 1] || dp[i + 2] || ... || dp[i + nums[i]]
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：824ms，击败7.17%。消耗内存：41.5MB，击败13.89%。
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i] |= dp[j + i];
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}