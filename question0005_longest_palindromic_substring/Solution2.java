package question0005_longest_palindromic_substring;

/**
 * 从某个点向两边扩展。
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(1)。
 *
 * 执行用时：37ms，击败58.89%。消耗内存：48.2MB，击败31.54%。
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.substring(0, 1);
        }
        String result = "";
        for (int i = 1; i < s.length() - 1; i++) {
            String odd = maxPalindrome(s, i - 1, i + 1);
            String even1 = maxPalindrome(s, i - 1, i),even2 = maxPalindrome(s, i, i + 1);
            if (odd.length() > result.length()) {
                result = odd;
            }
            if (even1.length() > result.length()) {
                result = even1;
            }
            if (even2.length() > result.length()) {
                result = even2;
            }
        }
        return result;
    }

    private String maxPalindrome(String s, int k, int j) {
        while (k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)) {
            k--;
            j++;
        }
        return s.substring(k + 1, j);
    }
}