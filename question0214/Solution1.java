package question0214;

/**
 * 求出始于字符串s首字符的最长回文串。再翻转非回文串部分，最后拼接即可。
 *
 * 时间复杂度是O(n ^ 2)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：448ms，击败10.64%。消耗内存：305.9MB，击败20.59%。
 */
public class Solution1 {
    public String shortestPalindrome(String s) {
        int index = -1; //防止s为空时越界
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s.substring(0, i + 1))) {
                index = i;
                break;
            }
        }
        String result = reverse(s.substring(index + 1));
        return result + s;
    }

    private String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
