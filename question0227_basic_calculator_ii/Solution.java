package question0227_basic_calculator_ii;

import java.util.LinkedList;

public class Solution {

  public int calculate(String s) {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    char preSign = '+';
    int num = 0;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
      }
      if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
        switch (preSign) {
          case '+':
            stack.push(num);
            break;
          case '-':
            stack.push(-num);
            break;
          case '*':
            stack.push(stack.pop() * num);
            break;
          default:
            stack.push(stack.pop() / num);
        }
        preSign = c;
        num = 0;
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }

}