package question053;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82796047
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
        int mid = left + (right - left) / 2;
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
