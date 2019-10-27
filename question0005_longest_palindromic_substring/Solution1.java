package question0005_longest_palindromic_substring;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 3)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：1120ms，击败5.03%。消耗内存：367.6MB，击败5.18%。
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length() - result.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
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