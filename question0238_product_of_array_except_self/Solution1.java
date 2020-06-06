package question0238_product_of_array_except_self;

/**
 * 时间复杂度是 O(n ^ 2)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：2393ms，击败5.11%。消耗内存：48.5MB，击败11.76%。
 */
public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    tmp *= nums[j];
                }
            }
            result[i] = tmp;
        }
        return result;
    }
}