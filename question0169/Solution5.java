package question0169;

/**
 * 位运算。依次确定结果数中每一位的值。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败66.65%。消耗内存：41.1MB，击败84.63%。
 */
public class Solution5 {
    public int majorityElement(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0, zeros = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            if (ones > zeros) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
