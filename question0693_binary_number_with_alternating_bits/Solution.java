package question0693_binary_number_with_alternating_bits;

/**
 * 位运算。
 *
 * 时间复杂度是O(logn)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.3MB，击败73.36%。
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int pre = -1;
        while (n > 0) {
            int num = (n & 1);
            if (num == pre) {
                return false;
            }
            pre = num;
            n >>= 1;
        }
        return true;
    }
}
