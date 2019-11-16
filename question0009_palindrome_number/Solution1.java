package question0009_palindrome_number;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * 先将输入的x用字符串形式来表示，再遍历该字符串判断是否是回文串。
 *
 * 时间复杂度是O(n)，其中n为x转化为字符串的长度。空间复杂度是O(1)。
 *
 * 执行用时：46ms，击败96.32%。消耗内存：36.9MB，击败90.37%。
 */
public class Solution1 {
    public boolean isPalindrome(int x) {
        String string = Integer.toString(x);
        int n = string.length();
        for (int i = 0; i <= n >> 1; i++) {
            if (string.charAt(i) != string.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}