package question0476_number_complement;

/**
 * 时间复杂度是O(log(num))。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败97.04%。消耗内存：33.3MB，击败74.03%。
 */
public class Solution {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num >>= 1;
        }
        int result = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            result = result * 2 + (1 - (sb.charAt(i) - '0'));
        }
        return result;
    }
}
