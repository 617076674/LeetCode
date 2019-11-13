package question0005_longest_palindromic_substring;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 3)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：1120ms，击败5.03%。消耗内存：367.6MB，击败5.18%。
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        int n;
        if (null == s || (n = s.length()) == 0) {
            return "";
        }
        String result = "";
        for (int i = 0; i < n - result.length(); i++) {
            for (int j = n - 1; j >= i; j--) {
                //对字符串s中[i, j]范围内的子串进行判断，判断其是否是回文串
                if ((j + 1 - i) > result.length() && isPalidrome(s.substring(i, j + 1))) {
                    result = s.substring(i, j + 1);
                    break;
                }
            }
        }
        return result;
    }

    private boolean isPalidrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}