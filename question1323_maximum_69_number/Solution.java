package question1323_maximum_69_number;

/**
 * 执行用时：1ms，击败96.31%。消耗内存：33.2MB，击败100.00%。
 */
public class Solution {
    public int maximum69Number (int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(digits));
    }
}