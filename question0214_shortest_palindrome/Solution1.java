package question0214_shortest_palindrome;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n ^ 2)，其中n为字符串s的长度。空间复杂度是O(n)。
 *
 * 执行用时：6ms，击败94.47%。消耗内存：37.9MB，击败58.82%。
 */
public class Solution1 {
    public String shortestPalindrome(String s) {
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        if (i == s.length()) {
            return s;
        }
        return reverse(s.substring(i)) + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }

    private String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }
}