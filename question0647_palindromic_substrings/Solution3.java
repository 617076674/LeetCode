package question0647_palindromic_substrings;

/**
 * 由某个点向两边扩展（注意讨论回文串长度为奇数和偶数两种情形）。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：4ms，击败83.74%。消耗内存：37.8MB，击败69.26%。
 */
public class Solution3 {
    private int count;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            countSubstrings(s, i, i);               //回文串长度为奇数
            countSubstrings(s, i, i + 1);     //回文串长度为偶数
        }
        return count;
    }

    private void countSubstrings(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
    }
}