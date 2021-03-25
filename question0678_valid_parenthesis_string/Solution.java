package question0678_valid_parenthesis_string;

import java.util.LinkedList;

/**
 * 栈的应用。
 */
public class Solution {

  public boolean checkValidString(String s) {
    LinkedList<Integer> stackLeft = new LinkedList<>(), stackStar = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stackLeft.addLast(i);
      } else if (c == '*') {
        stackStar.addLast(i);
      } else {
        if (stackLeft.isEmpty() && stackStar.isEmpty()) {
          return false;
        }
        if (!stackLeft.isEmpty()) {
          stackLeft.pollLast();
        } else {
          stackStar.pollLast();
        }
      }
    }
    while (!stackLeft.isEmpty() && !stackStar.isEmpty()) {
      if (stackLeft.pollLast() > stackStar.pollLast()) {
        return false;
      }
    }
    return stackLeft.isEmpty();
  }

}