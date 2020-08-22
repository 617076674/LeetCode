package question0647_palindromic_substrings;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为字符串 s 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：757ms，击败5.00%。消耗内存：40.3MB，击败7.63%。
 */
public class Solution1 {
    public int countSubstrings(String s) {
        int count = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (isPalindrom(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}