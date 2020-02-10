package question1021_remove_outermost_parentheses;

/**
 * 时间复杂度是O(n)，其中n是字符串S的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败70.19%。消耗内存：37.9MB，击败19.63%。
 */
public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int left = 0, right = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result.append(S, start + 1, i);
                start = i + 1;
            }
        }
        return result.toString();
    }
}