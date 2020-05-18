package question0152_maximum_product_subarray;

/**
 * 状态压缩。
 *
 * 时间复杂度是 O(n)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：2ms，击败92.58%。消耗内存：40MB，击败6.67%。
 */
public class Solution3 {
    public int maxProduct(int[] nums) {
        int result = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            } else {
                int tmp = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(tmp * nums[i], nums[i]);
            }
            result = Math.max(result, max);
        }
        return result;
    }
}