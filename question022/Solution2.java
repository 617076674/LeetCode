package question022;

import java.util.ArrayList;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82259034
 */
public class Solution2 {

    List<String> list;
    List<Character> brackets;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        brackets = new ArrayList<>();
        brackets.add('(');
        brackets.add(')');
        generateParenthesis(new StringBuilder(), 0, 0, n);
        return list;
    }

    private void generateParenthesis(StringBuilder stringBuilder, int leftCount, int rightCount, int n) {
        if (leftCount + rightCount == 2 * n) {
            list.add(stringBuilder.toString());
            return;
        }
        if (leftCount == rightCount) {
            stringBuilder.append(brackets.get(0));
            generateParenthesis(stringBuilder, leftCount + 1, rightCount, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else if (leftCount > rightCount) {
            if (leftCount == n) {
                stringBuilder.append(brackets.get(1));
                generateParenthesis(stringBuilder, leftCount, rightCount + 1, n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else if (leftCount < n) {
                for (int i = 0; i < brackets.size(); i++) {
                    stringBuilder.append(brackets.get(i));
                    if (i == 0) {
                        generateParenthesis(stringBuilder, leftCount + 1, rightCount, n);
                    } else {
                        generateParenthesis(stringBuilder, leftCount, rightCount + 1, n);
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
    }
}
