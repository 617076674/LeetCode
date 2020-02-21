package question0005_longest_palindromic_substring;

/**
 * 从某个点向两边扩展。
 *
 * 回文串分为两种，长度为奇数的回文串和长度为偶数的回文串。
 *
 * 以字符串s中[1, s.length() - 1]范围内的字符i为中心，寻找3类回文串。
 *
 * （1）以i为中心的长度为奇数的回文串。
 *
 * （2）以(i - 1)和i为中心的长度为偶数的回文串。
 *
 * （3）以i和(i + 1)为中心的长度为偶数的回文串。
 *
 * 取上述三类回文串中的最长者，就是以字符i为中心可能构成的最长回文子串。
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(1)。
 *
 * 执行用时：37ms，击败58.89%。消耗内存：48.2MB，击败31.54%。
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        int n;
        if (null == s || (n = s.length()) < 2) {
            return s;
        }
        if (n == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.substring(0, 1);
        }
        String result = "";
        for (int i = 1; i < n - 1; i++) {
            String odd = maxPalindrome(s, i - 1, i + 1), even1 = maxPalindrome(s, i - 1, i),
                    even2 = maxPalindrome(s, i, i + 1);
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