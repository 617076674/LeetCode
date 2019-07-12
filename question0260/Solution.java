package question0260;

/**
 * 异或位运算。在question0136的基础上做一个区分。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败95.72%。消耗内存：40.5MB，击败37.06%。
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int num1XORNum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            num1XORNum2 ^= nums[i];
        }
        num1XORNum2 &= -num1XORNum2;    //取num1XORNum2最右边的1，其余位均置为0
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (0 == (nums[i] & num1XORNum2)) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}
