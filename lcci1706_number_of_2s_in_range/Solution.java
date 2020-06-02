package lcci1706_number_of_2s_in_range;

/**
 * 统计各个位置上 2 出现的次数。
 *
 * 时间复杂度是 O(logn)。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.7MB，击败100.00%。
 */
public class Solution {
    public int numberOf2sInRange(int n) {
        if (n < 2) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        String string = String.valueOf(n);
        int result = 0, len = string.length();
        for (int i = 0; i < len; i++) {
            char c = string.charAt(i);
            if (i == 0) {
                if (c == '2') {
                    result += Integer.parseInt(string.substring(1)) + 1;
                } else if (c != '0' && c != '1') {
                    result += Math.pow(10, len - 1);
                }
            } else if (i == len - 1) {
                result += Integer.parseInt(string.substring(0, len - 1));
                if (c != '0' && c != '1') {
                    result++;
                }
            } else {
                if (c == '2') {
                    result += Integer.parseInt(string.substring(0, i)) * Math.pow(10, len - i - 1) + Integer.parseInt(string.substring(i + 1)) + 1;
                } else if (c == '0' || c == '1') {
                    result += Integer.parseInt(string.substring(0, i)) * Math.pow(10, len - i - 1);
                } else {
                    result += (Integer.parseInt(string.substring(0, i)) + 1) * Math.pow(10, len - i - 1);
                }
            }
        }
        return result;
    }
}