package lcci1704_missing_number;

public class Solution {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && i != nums[i]) {
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}