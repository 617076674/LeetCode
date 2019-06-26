package question169;

public class Solution3 {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (right - left) / 2 + left;
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
