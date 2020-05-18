package question0152_maximum_product_subarray;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：110ms，击败6.72%。消耗内存：40MB，击败6.67%。
 */
public class Solution1 {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = i; j < nums.length; j++) {
                tmp *= nums[j];
                result = Math.max(result, tmp);
            }
        }
        return result;
    }
}