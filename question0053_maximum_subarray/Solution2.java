package question0053_maximum_subarray;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 分治算法。
 *
 * 时间复杂度和空间复杂度均是O(nlogn)，其中n是nums数组的长度。
 *
 * 执行用时：2ms，击败97.99%。消耗内存：37.7MB，击败88.98%。
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + ((right - left) >> 1), leftResult = maxSubArray(nums, left, mid),
                rightResult = maxSubArray(nums, mid + 1, right), leftSum = 0, midLeftResult = Integer.MIN_VALUE,
                rightSum = 0, midRightResult = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            midLeftResult = Math.max(midLeftResult, leftSum);
        }
        for (int i = mid + 1; i <= right; i++) {
            rightSum += nums[i];
            midRightResult = Math.max(midRightResult, rightSum);
        }
        return Math.max(leftResult, Math.max(rightResult, midLeftResult + midRightResult));
    }
}