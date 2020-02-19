package question0421_maximum_xor_of_two_numbers_in_an_array;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums的长度。空间复杂度是O(1)。
 *
 * 执行用时：149ms，击败9.64%。消耗内存：49.5MB，击败16.08%。
 */
public class Solution1 {
    public int findMaximumXOR(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) < 2) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                result = Math.max(result, nums[i] ^ nums[j]);
            }
        }
        return result;
    }
}