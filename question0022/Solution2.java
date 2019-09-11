package question0022;

import java.util.ArrayList;
import java.util.List;

/**
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

    private void generateParenthesis(StringBuilder stringBuilder, int leftCount, int rightCount, int n) {
        if (leftCount + rightCount == 2 * n) {
            result.add(stringBuilder.toString());
            return;
        }
        if (leftCount == rightCount) {
            stringBuilder.append('(');
            generateParenthesis(stringBuilder, leftCount + 1, rightCount, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else if (leftCount > rightCount) {
            if (leftCount == n) {
                stringBuilder.append(')');
                generateParenthesis(stringBuilder, leftCount, rightCount + 1, n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else if (leftCount < n) {
                stringBuilder.append('(');
                generateParenthesis(stringBuilder, leftCount + 1, rightCount, n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append(')');
                generateParenthesis(stringBuilder, leftCount, rightCount + 1, n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
