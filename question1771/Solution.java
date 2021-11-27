package question1771;

public class Solution {

    private Integer[][] memo = new Integer[2001][2001];

    private int result, n1, n2;

    public int longestPalindrome(String word1, String word2) {
        n1 = word1.length();
        n2 = word2.length();
        longestPalindromeHelper(word1 + word2, 0, n1 + n2 - 1);
        return result;
    }

    // 字符串 s 中 [left, right] 范围内的子序列其最长回文子串的长度
    private int longestPalindromeHelper(String s, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 1;
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        boolean flag = s.charAt(left) == s.charAt(right);
        if (flag) {
            memo[left][right] = 2 + longestPalindromeHelper(s, left + 1, right - 1);
        } else {
            memo[left][right] = Math.max(longestPalindromeHelper(s, left + 1, right), longestPalindromeHelper(s, left, right - 1));
        }
        if (left < n1 && right >= n1 && flag) {
            result = Math.max(result, memo[left][right]);
        }
        return memo[left][right];
    }

}