package question016;

import java.util.Arrays;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82177199
 */
public class Solution2 {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    if (Math.abs(nums[i] + nums[left] + nums[right] - target) < diff) {
                        diff = Math.abs(nums[i] + nums[left] + nums[right] - target);
                        result = nums[i] + nums[left] + nums[right];
                    }
                    left++;
                } else if (nums[i] + nums[left] + nums[right] == target) {
                    return target;
                } else {
                    if (Math.abs(nums[i] + nums[left] + nums[right] - target) < diff) {
                        diff = Math.abs(nums[i] + nums[left] + nums[right] - target);
                        result = nums[i] + nums[left] + nums[right];
                    }
                    right--;
                }
            }
        }
        return result;
    }
}
