package question0238_product_of_array_except_self;

/**
 * 时间复杂度是 O(n)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：48.2MB，击败11.76%。
 */
public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int tmp = nums[0];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        tmp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
