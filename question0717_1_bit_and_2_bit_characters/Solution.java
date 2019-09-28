package question0717_1_bit_and_2_bit_characters;

/**
 * 其实结果是唯一确定的。
 *
 * 时间复杂度是O(n)，其中n为bits数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36MB，击败88.35%。
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n;
        if (null == bits || (n = bits.length) == 0) {
            return false;
        }
        int index = 0;
        while (true) {
            if (index == n - 1) {
                return true;
            } else if (index >= n) {
                return false;
            }
            if (bits[index] == 1) {
                index += 2;
            } else {
                index++;
            }
        }
    }
}
