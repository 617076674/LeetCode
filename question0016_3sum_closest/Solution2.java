package question0016_3sum_closest;

import java.util.Arrays;

/**
 * 内层循环采用双指针遍历的形式。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败94.94%。消耗内存：39.1MB，击败6.82%。
 */
public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, diff = Integer.MAX_VALUE, result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    if (Math.abs(sum - target) < diff) {
                        diff = Math.abs(sum - target);
                        result = sum;
                    }
                    left++;
                } else if (sum == target) {
                    return target;
                } else {
                    if (Math.abs(sum - target) < diff) {
                        diff = Math.abs(sum - target);
                        result = sum;
                    }
                    right--;
                }
            }
        }
        return result;
    }
}