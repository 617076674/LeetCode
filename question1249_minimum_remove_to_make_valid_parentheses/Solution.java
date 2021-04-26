package question1249_minimum_remove_to_make_valid_parentheses;

import java.util.LinkedList;

public class Solution {

  public String minRemoveToMakeValid(String s) {
    boolean[] valid = new boolean[s.length()];
    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        linkedList.addLast(i);
      } else if (c == ')') {
        if (!linkedList.isEmpty() && s.charAt(linkedList.peekLast()) == '(') {
          valid[i] = valid[linkedList.pollLast()] = true;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == ')') {
        if (valid[i]) {
          sb.append(c);
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

}