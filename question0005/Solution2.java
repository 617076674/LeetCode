package question0005;

/**
 * 还是暴力破解法，不过第二重循环倒着遍历，做一个小小的改进。
 *
 * 时间复杂度和空间复杂度不变。
 *
 * 在LeetCode中提交依然会超时。
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length() - result.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalidrome(s.substring(i, j + 1)) && (j + 1 - i) > result.length()) {
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
