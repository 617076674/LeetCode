package question0016;

import java.util.Arrays;

/**
 * 和question0015中的Solution3采用同样的思路，内层循环采用双指针遍历的形式。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：17ms，击败48.29%。消耗内存：36.5MB，击败84.07%。
 */
public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, diff = Integer.MAX_VALUE, result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
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