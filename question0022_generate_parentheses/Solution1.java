package question0022_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 先生成出所有可能的括号组合，再筛选出有效的括号组合。
 *
 * 时间复杂度是O(n * (2 ^ n))。空间复杂度是O(n)。
 *
 * 执行用时：23ms，击败5.86%。消耗内存：44.9MB，击败5.02%。
 */
public class Solution1 {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(new StringBuilder(), 0, n);
        return result;
    }

    private void generateParenthesis(StringBuilder sb, int index, int n) {
        if (index == (n << 1)) {
            if (isValidString(sb.toString())) {
                result.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        generateParenthesis(sb, index + 1, n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        generateParenthesis(sb, index + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isValidString(String string) {
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (rightCount > leftCount) {
                return false;
            }
        }
        return rightCount == leftCount;
    }
}
