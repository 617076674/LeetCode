package question0016_3sum_closest;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * 和question0015中的Solution3采用同样的思路，内层循环采用双指针遍历的形式。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败94.94%。消耗内存：36.4MB，击败84.12%。
 */
public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, diff = Integer.MAX_VALUE, result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp < target) {
                    if (Math.abs(tmp - target) < diff) {
                        diff = Math.abs(tmp - target);
                        result = tmp;
                    }
                    left++;
                } else if (tmp == target) {
                    return target;
                } else {
                    if (Math.abs(tmp - target) < diff) {
                        diff = Math.abs(tmp - target);
                        result = tmp;
                    }
                    right--;
                }
            }
        }
        return result;
    }
}