package question0680_valid_palindrome_ii;

/**
 * 如果字符串的起始字符和结束字符相同（即s.charAt(0) == s.charAt(s.length() - 1)），
 * 则内部字符是否为回文s.substring(1, s.length() - 1)将唯一地确定整个字符串是否为回文。
 *
 * 假设我们想知道s.substring(left, right + 1)是否形成回文。如果 left >= right，就结束判断。
 * 如果s.charAt(left) = s.charAt(right)，那么我们可以取left++;right--。
 * 否则，回文必须是s.substring(left + 1, right + 1)或s.substring(left, right)这两种情况。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：11ms，击败91.47%。消耗内存：38.6MB，击败92.37%。
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s.substring(left + 1, right + 1)) || isPalindrome(s.substring(left, right));

            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}