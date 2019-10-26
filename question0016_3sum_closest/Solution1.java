package question0016_3sum_closest;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 3)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：188ms，击败5.23%。消耗内存：36.9MB，击败83.68%。
 */
public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, diff = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < diff) {
                        diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        result = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return result;
    }
}