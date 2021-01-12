package question1717_maximum_score_from_removing_substrings;

import java.util.Stack;

public class Solution {

  public int maximumGain(String s, int x, int y) {
    s = s + "c";
    char[] chars = {'a', 'b'};
    int result = 0;
    Stack<Character> stack = new Stack<>();
    int index = x > y ? 0 : 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == chars[index]) {
        stack.push(c);
      } else if (c == chars[1 - index]) {
        if (!stack.isEmpty() && stack.peek() == chars[index]) {
          stack.pop();
          result += Math.max(x, y);
        } else {
          stack.push(c);
        }
      } else {
        Stack<Character> anotherStack = new Stack<>();
        while (!stack.isEmpty()) {
          char tmp = stack.pop();
          if (tmp == chars[index]) {
            anotherStack.push(tmp);
          } else {
            if (!anotherStack.isEmpty() && anotherStack.peek() == chars[index]) {
              anotherStack.pop();
              result += Math.min(x, y);
            } else {
              anotherStack.push(c);
            }
          }
        }
      }
    }
    return result;
  }

}