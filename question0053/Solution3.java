package question0053;

/**
 * 分治算法。
 *
 * 时间复杂度和空间复杂度均是O(nlogn)，其中n是nums数组的长度。
 *
 * 执行用时：2ms，击败97.99%。消耗内存：37.7MB，击败88.98%。
 */
public class Solution3 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int result = maxSubArray(nums, 0, n - 1);
        return result;
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftResult = maxSubArray(nums, left, mid);
        int rightResult = maxSubArray(nums, mid + 1, right);
        int leftSum = 0;
        int midLeftResult = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            midLeftResult = Math.max(midLeftResult, leftSum);
        }
        int rightSum = 0;
        int midRightResult = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            rightSum += nums[i];
            midRightResult = Math.max(midRightResult, rightSum);
        }
        int midResult = midLeftResult + midRightResult;
        return Math.max(leftResult, Math.max(rightResult, midResult));
    }
}
