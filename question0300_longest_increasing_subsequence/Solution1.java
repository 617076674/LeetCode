package question0300_longest_increasing_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]表示以索引i处数字结尾的最长上升子序列的长度。
 *
 * 初始化条件：
 * dp[0] = 1。
 *
 * 状态转移方程：
 * dp[i] = Math.max(dp[j] + 1, dp[i])，其中j∈[0, i)且nums[i] > nums[j]。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：36ms，击败5.39%。消耗内存：37.6MB，击败7.14%。
 */
public class Solution1 {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, lengthOfLTS(nums, i));
        }
        return result;
    }

    /**
     * 计算以 nums[right] 结尾的最长上升子序列长度
     */
    private int lengthOfLTS(int[] nums, int right) {
        if (right == 0) {
            return 1;
        }
        if (memo.containsKey(right)) {
            return memo.get(right);
        }
        int result = 1;
        for (int i = 0; i < right; i++) {
            if (nums[right] > nums[i]) {
                result = Math.max(result, lengthOfLTS(nums, i) + 1);
            }
        }
        memo.put(right, result);
        return result;
    }

}