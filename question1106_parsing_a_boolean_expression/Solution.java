package question1106_parsing_a_boolean_expression;

import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().parseBoolExpr("!(f)"));
    System.out.println(new Solution().parseBoolExpr("|(f,t)"));
    System.out.println(new Solution().parseBoolExpr("&(t,f)"));
    System.out.println(new Solution().parseBoolExpr("|(&(t,f,t),!(t))"));
  }

  public boolean parseBoolExpr(String expression) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      switch (c) {
        case '|':
        case '!':
        case '&':
        case '(':
        case 't':
        case 'f':
          stack.push(c);
          break;
        case ')':
          int countT = 0, countF = 0;
          while (stack.peek() != '(') {
            if (stack.pop() == 'f') {
              countF++;
            } else {
              countT++;
            }
          }
          stack.pop();
          if (!stack.isEmpty() && stack.peek() == '|' || stack.peek() == '&' || stack.peek() == '!') {
            switch (stack.pop()) {
              case '|':
                if (countT > 0) {
                  stack.push('t');
                } else {
                  stack.push('f');
                }
                break;
              case '&':
                if (countF > 0) {
                  stack.push('f');
                } else {
                  stack.push('t');
                }
                break;
              case '!':
                if (countF > 0) {
                  stack.push('t');
                } else {
                  stack.push('f');
                }
            }
          }
          break;
      }
    }
    return stack.peek() == 't';
  }

}