package question0698_partition_to_k_equal_sum_subsets;

/**
 * 执行用时：1ms，击败100.00%。消耗内存：37.5MB，击败9.09%。
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % k != 0 || max > sum / k) {
            return false;
        }
        return canPartitionKSubsets(nums, 0, k, 0, sum / k, new boolean[nums.length]);
    }

    /**
     * 在 nums 数组 [start, nums.length - 1] 范围内搜索 k 个相等的子集，当前子集的和是 now，各个子集的目标和是 target。
     */
    private boolean canPartitionKSubsets(int[] nums, int start, int k, int now, int target, boolean[] used) {
        if (k == 1) {
            return true;
        }
        if (now == target) {
            return canPartitionKSubsets(nums, 0, k - 1, 0, target, used);
        } else if (now > target) {
            return false;
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                // 规定只往右搜，可以减少大量的重复搜索
                if (canPartitionKSubsets(nums, i + 1, k, now + nums[i], target, used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}