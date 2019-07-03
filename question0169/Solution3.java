package question0169;

/**
 * 分治算法。求左半区间和右半区间的众数。
 *
 * 时间复杂度是O(nlogn)，其中n数nums数组的长度。空间复杂度是O(logn)。
 *
 * 执行用时：2ms，击败99.76%。消耗内存：40.2MB，击败92.27%。
 */
public class Solution3 {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = ((right - left) >> 1) + left;
        int leftResult = majorityElementRec(nums, left, mid);
        int rightResult = majorityElementRec(nums, mid + 1, right);
        if (leftResult == rightResult) {
            return leftResult;
        }
        int leftCount = countInRange(nums, leftResult, left, right);
        int rightCount = countInRange(nums, rightResult, left, right);
        return leftCount > rightCount ? leftResult : rightResult;
    }

    private int countInRange(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
