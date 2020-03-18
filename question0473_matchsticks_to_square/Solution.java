package question0473_matchsticks_to_square;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 由于nums数组不超过15位，故可以用一个 int 型整数来保存当前的状态（状态即哪些位置的元素已经被使用，哪些位置的元素没有被使用）。
 *
 * 时间复杂度是 O(n * (2 ^ n))，其中 n 为 nums 数组的长度。空间复杂度是 O(n)。
 *
 * 执行用时：18ms，击败79.15%。消耗内存：41.5MB，击败5.05%。
 */
public class Solution {
    private Map<Integer, Boolean> memo = new HashMap<>();

    public boolean makesquare(int[] nums) {
        if (null == nums || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        return dfs(nums, 0, sum >> 2, 0);
    }

    private boolean dfs(int[] nums, int tmp, int target, int status) {
        if (memo.containsKey(status)) {
            return memo.get(status);
        }
        if (status == Math.pow(2, nums.length) - 1) {
            return true;
        }
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if ((status & (1 << i)) == 0) {
                if (tmp + nums[i] == target) {
                    if (dfs(nums, 0, target, status | (1 << i))) {
                        result = true;
                        break;
                    }
                } else if (tmp + nums[i] < target) {
                    if (dfs(nums, tmp + nums[i], target, status | (1 << i))) {
                        result = true;
                        break;
                    }
                }
            }
        }
        memo.put(status, result);
        return result;
    }
}