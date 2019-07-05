package question0233;

/**
 * 累加每位上1出现的次数。
 *
 * 时间复杂度是O(logn)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：32.9MB，击败16.28%。
 */
public class Solution {
    public int countDigitOne(int n) {
        int result = 0;
        if (n <= 0) {
            return result;
        }
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            if (i == 0) {   //首位特殊处理
                if (number.charAt(i) == '1') {
                    int right = 0;
                    for (int j = 1; j < number.length(); j++) {
                        right = right * 10 + number.charAt(j) - '0';
                    }
                    result += right + 1;
                } else {
                    result += Math.pow(10, number.length() - 1);
                }
            } else if (i == number.length() - 1) {
                int left = 0;
                for (int j = 0; j < number.length() - 1; j++) {
                    left = left * 10 + number.charAt(j) - '0';
                }
                result += left + 1;
                if (number.charAt(i) == '0') {
                    result--;
                }
            } else {
                int left = 0, right = 0;
                for (int j = 0; j < i; j++) {
                    left = left * 10 + number.charAt(j) - '0';
                }
                for (int j = i + 1; j < number.length(); j++) {
                    right = right * 10 + number.charAt(j) - '0';
                }
                if (number.charAt(i) == '0') {
                    result += left * Math.pow(10, number.length() - i - 1);
                } else if (number.charAt(i) == '1') {
                    result += left * Math.pow(10, number.length() - i - 1) + right + 1;
                } else {
                    result += (left + 1) * Math.pow(10, number.length() - i - 1);
                }
            }
        }
        return result;
    }
}
