package question0680_valid_palindrome_ii;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    public boolean validPalindrome(String s) {
        for (int i = -1; i < s.length(); i++) {
            if (isPalindrome(s, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(String s, int index) {
        int n = s.length();
        if (index == -1) {
            for (int i = 0; i <= n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - 1 - i)) {
                    return false;
                }
            }
            return true;
        } else {
            int left = 0, right = n - 1;
            while (left < right) {
                if (left == index) {
                    left++;
                }
                if (right == index) {
                    right--;
                }
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
