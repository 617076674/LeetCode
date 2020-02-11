package question0066_plus_one;

/**
 * 字符串加法。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为digits数组的长度。
 *
 * 执行用时：1ms，击败97.63%。消耗内存：35.6MB，击败36.83%。
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, flag = 1;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = digits[i] + flag;
            if (digits[i] >= 10) {
                digits[i] -= 10;
            } else {
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}