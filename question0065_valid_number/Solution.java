package question0065_valid_number;

/**
 * https://leetcode-cn.com/problems/valid-number/
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败62.60%。消耗内存：42MB，击败5.25%。
 */
public class Solution {
    public boolean isNumber(String s) {
        int left = 0;
        while (s.charAt(left) == ' ') {
            left++;
            if (left == s.length()) {
                return false;
            }
        }
        int right = s.length() - 1;
        while (s.charAt(right) == ' ') {
            right--;
        }
        s = s.substring(left, right + 1);
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        int countPoint = 0, countE = 0, indexPoint = -1, indexE = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c == '.' || c == 'e' || c == 'E' || (c >= '0' && c <= '9'))) {
                return false;
            }
            if (c == '.') {
                indexPoint = i;
                if (++countPoint >= 2) {
                    return false;
                }
            }
            if (c == 'e' || c == 'E') {
                indexE = i;
                if (indexE < s.length() - 1) {
                    if (s.charAt(indexE + 1) == '-' || s.charAt(indexE + 1) == '+') {
                        if (indexE + 1 == s.length() - 1) {
                            return false;
                        }
                        i++;
                    }
                }
                if (++countE >= 2) {
                    return false;
                }
            }
        }
        if ((indexPoint == 0 && (s.length() == 1 || indexPoint + 1 == indexE)
                || (indexE == 0 || indexE == s.length() - 1) || (indexE != -1 && indexPoint > indexE))) {
            return false;
        }
        return true;
    }
}