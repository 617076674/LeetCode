package question0540_single_element_in_a_sorted_array;

public class Solution {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == nums[mid + 1]) {
                if (((mid - left) & 1) == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (((mid - left + 1) & 1) == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new Solution().singleNonDuplicate(nums));
    }

}