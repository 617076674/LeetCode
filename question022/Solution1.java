package question022;

import java.util.ArrayList;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82259034
 */
public class Solution1 {

    private List<String> list;
    List<Character> brackets;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        brackets = new ArrayList<>();
        brackets.add('(');
        brackets.add(')');
        generateParenthesis(new StringBuilder(), 0, n);
        return list;
    }

    private void generateParenthesis(StringBuilder stringBuilder, int index, int n) {
        if (index == 2 * n) {
            if (isValidString(stringBuilder.toString())) {
                list.add(stringBuilder.toString());
            }
            return;
        }
        for (int i = 0; i < brackets.size(); i++) {
            stringBuilder.append(brackets.get(i));
            generateParenthesis(stringBuilder, index + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    private boolean isValidString(String string) {
        int leftCount = 0;
        int rightCount = 0;
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
