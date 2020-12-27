package question0153_find_minimum_in_rotated_sorted_array;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败97.91%。消耗内存：36.2MB，击败40.66%。
 */
public class Solution1 {

    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }

}
