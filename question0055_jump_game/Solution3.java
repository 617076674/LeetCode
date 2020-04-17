package question0055_jump_game;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 贪心算法。
 *
 * 在Solution1的动态规划解法中，其状态转移为：dp[i] = dp[i + 1] || dp[i + 2] || ... || dp[i + nums[i]]
 * 实际上我们只需要找到第一个dp[i + j]为true的值即可，即最右侧的为true的值。用一个变量lastPos来保存这个最右侧的为true的值，以避免遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：2ms，击败96.94%。消耗内存：41.9MB，击败70.87%。
 */
public class Solution3 {
    public boolean canJump(int[] nums) {
        int n = nums.length, lastPos = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {   //我们能从i处跳到lastPost处
                lastPos = i;
            }
        }
        return 0 == lastPos;
    }
}