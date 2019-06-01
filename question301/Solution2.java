package question301;


import java.util.*;

public class Solution2 {

    private Set<String> set;

    private String input;

    private int maxLen = 0;

    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        input = s;
        removeInvalidParentheses(0, "", 0, 0);
        return new ArrayList<>(set);
    }

    private void removeInvalidParentheses(int index, String valid, int leftCount, int rightCount) {
        if (leftCount < rightCount) {
            return;
        }
        if (index == input.length()) {
            if (leftCount == rightCount) {
                if (maxLen < valid.length()) {
                    maxLen = valid.length();
                    set.clear();
                    set.add(valid);
                } else if (maxLen == valid.length()) {
                    set.add(valid);
                }
            }
            return;
        }
        char c = input.charAt(index);
        if (c == '(') {
            removeInvalidParentheses(index + 1, valid, leftCount, rightCount);
            removeInvalidParentheses(index + 1, valid + c, leftCount + 1, rightCount);
        } else if (c == ')') {
            removeInvalidParentheses(index + 1, valid, leftCount, rightCount);
            removeInvalidParentheses(index + 1, valid + c, leftCount, rightCount + 1);
        } else {
            removeInvalidParentheses(index + 1, valid + c, leftCount, rightCount);
        }
    }

}
