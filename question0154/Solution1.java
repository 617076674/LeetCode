package question0154;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败82.57%。消耗内存：38.4MB，击败27.47%。
 */
public class Solution1 {
    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < result) {
                result = nums[i];
            }
        }
        return result;
    }
}
