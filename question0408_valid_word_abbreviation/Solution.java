package question0408_valid_word_abbreviation;

/**
 * 双指针。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为字符串word的长度，n2为字符串abbr的长度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：34.5MB，击败100.00%。
 */
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n1 = word.length(), n2 = abbr.length(), i = 0, j = 0;
        while (i < n1 && j < n2) {
            char c1 = word.charAt(i), c2 = abbr.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else if (c2 >= '0' && c2 <= '9') {
                if (c2 == '0') {
                    return false;
                }
                int num = 0;
                while (j < n2 && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    num = num * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += num;
            } else {
                return false;
            }
        }
        return i == n1 && j == n2;
    }
}