package question0504_base_7;

/**
 * 时间复杂度是O(log(num))。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：33.9MB，击败33.9MB，击败95.63%。
 */
public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num *= -1;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        String result = sb.reverse().toString();
        if (isNegative) {
            result = "-" + result;
        }
        return result;
    }
}
