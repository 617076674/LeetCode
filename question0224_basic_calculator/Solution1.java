package question0224_basic_calculator;

import java.util.LinkedList;

public class Solution1 {

  public int calculate(String s) {
    LinkedList<Integer> ops = new LinkedList<>();
    ops.push(1);
    int sign = 1, result = 0, i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      switch (c) {
        case ' ':
          i++;
          break;
        case '+':
          sign = ops.peek();
          i++;
          break;
        case '-':
          sign = -ops.peek();
          i++;
          break;
        case '(':
          ops.push(sign);
          i++;
          break;
        case ')':
          ops.pop();
          i++;
          break;
        default:
          long num = 0;
          while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i++) - '0';
          }
          result += sign * num;
      }
    }
    return result;
  }

}