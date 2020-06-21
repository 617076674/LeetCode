package question0125_valid_palindrome;

/**
 * 双指针。
 *
 * 时间复杂度是 O(n)，其中 n 为字符串 s 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：3ms，击败93.04%。消耗内存：40MB，击败7.14%。
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isLetterOrNumber(s.charAt(left))) {
                left++;
            }
            while (left < right && !isLetterOrNumber(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLetterOrNumber(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}