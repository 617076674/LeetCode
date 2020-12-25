package lcof67_ba_zi_fu_chuan_zhuan_huan_cheng_zheng_shu;

public class Solution {

    public int strToInt(String str) {
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        boolean isPositive = true;
        if (index < str.length()) {
            char c = str.charAt(index);
            if (c == '+') {
                index++;
            } else if (c == '-') {
                index++;
                isPositive = false;
            }
        }
        long result = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            result = result * 10 + (str.charAt(index) - '0');
            index++;
            if (isPositive && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (!isPositive && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (isPositive ?  result : -result);
    }

}