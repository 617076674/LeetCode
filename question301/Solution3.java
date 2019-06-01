package question301;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {

    private Set<String> set;

    private String input;

    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        input = s;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        removeInvalidParentheses(0, "", 0, 0, left, right);
        return new ArrayList<>(set);
    }

    private void removeInvalidParentheses(int index, String valid, int leftCount, int rightCount, int leftRem, int rightRem) {
        if (index == input.length()) {
            if (leftRem == 0 && rightRem == 0) {
                set.add(valid);
            }
            return;
        }
        char c = input.charAt(index);
        if (c == '(') {
            if (leftRem > 0) {
                removeInvalidParentheses(index + 1, valid, leftCount, rightCount, leftRem - 1, rightRem);
            }
            removeInvalidParentheses(index + 1, valid + c, leftCount + 1, rightCount, leftRem, rightRem);
        } else if (c == ')') {
            if (rightRem > 0) {
                removeInvalidParentheses(index + 1, valid, leftCount, rightCount, leftRem, rightRem - 1);
            }
            if (rightCount < leftCount) {
                removeInvalidParentheses(index + 1, valid + c, leftCount, rightCount + 1, leftRem, rightRem);
            }
        } else {
            removeInvalidParentheses(index + 1, valid + c, leftCount, rightCount, leftRem, rightRem);
        }
    }

}
