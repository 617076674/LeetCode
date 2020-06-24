package question0016_3sum_closest;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 3)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：12ms，击败12.61%。消耗内存：39.1MB，击败6.82%。
 */
public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, diff = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return sum;
                    }
                    if (Math.abs(sum - target) < diff) {
                        diff = Math.abs(sum - target);
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}