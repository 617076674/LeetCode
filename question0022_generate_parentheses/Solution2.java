package question0022_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 在Solution1的基础上添加剪枝操作。
 *
 * 时间复杂度是O(n * (2 ^ n))。空间复杂度是O(n)。
 *
 * 执行用时：2ms，击败93.31%。消耗内存：37.5MB，击败85.61%。
 */
public class Solution2 {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void generateParenthesis(StringBuilder sb, int leftCount, int rightCount, int n) {
        if (leftCount + rightCount == (n << 1)) {
            result.add(sb.toString());
            return;
        }
        if (leftCount == rightCount) {
            sb.append('(');
            generateParenthesis(sb, leftCount + 1, rightCount, n);
            sb.deleteCharAt(sb.length() - 1);
        } else if (leftCount > rightCount) {
            if (leftCount == n) {
                sb.append(')');
                generateParenthesis(sb, leftCount, rightCount + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            } else if (leftCount < n) {
                sb.append('(');
                generateParenthesis(sb, leftCount + 1, rightCount, n);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(')');
                generateParenthesis(sb, leftCount, rightCount + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}