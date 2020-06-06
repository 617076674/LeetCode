package lcci1617_contiguous_sequence;

/**
 * 分治算法。
 *
 * 时间复杂度是 O(nlogn)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败94.85%。消耗内存：39.8MB，击败100.00%。
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
                rightResult = maxSubArray(nums, mid + 1, right);
        int leftMax = nums[mid], leftSum = nums[mid], i = mid;
        while (i - 1 >= left) {
            leftSum += nums[i - 1];
            leftMax = Math.max(leftMax, leftSum);
            i--;
        }
        int rightMax = nums[mid + 1], rightSum = nums[mid + 1];
        i = mid + 1;
        while (i + 1 <= right) {
            rightSum += nums[i + 1];
            rightMax = Math.max(rightMax, rightSum);
            i++;
        }
        return Math.max(leftResult, Math.max(rightResult, leftMax + rightMax));
    }
}