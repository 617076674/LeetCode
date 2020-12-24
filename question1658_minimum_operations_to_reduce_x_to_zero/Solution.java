package question1658_minimum_operations_to_reduce_x_to_zero;

public class Solution {

    public int minOperations(int[] nums, int x) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int target = sums[nums.length] - x;
        if (target < 0) {
            return -1;
        }
        int reserved = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int index = binarySearch(sums, sums[i] + target);
            if (index != -1) {
                reserved = Math.max(reserved, index - i);
            }
        }
        if (reserved == Integer.MIN_VALUE) {
            return -1;
        }
        return nums.length - reserved;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}