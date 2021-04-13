package question0856_score_of_parentheses;

import java.util.LinkedList;

public class Solution {

  public int scoreOfParentheses(String S) {
    LinkedList<Integer> stack = new LinkedList<>();
    stack.push(0);
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c == '(') {
        stack.push(0);
      } else {
        int v = stack.pop();
        int w = stack.pop();
        stack.push(w + Math.max(2 * v, 1));
      }
    }
    return stack.pop();
  }

}