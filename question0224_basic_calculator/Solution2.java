package question0224_basic_calculator;

import java.util.LinkedList;

public class Solution2 {

  private LinkedList<Integer> numStack = new LinkedList<>();

  private LinkedList<Character> operationStack = new LinkedList<>();

  public int calculate(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '(':
          operationStack.addLast(c);
          break;
        case ')':
          while (!operationStack.isEmpty() && operationStack.peekLast() != '(') {
            calculateHelper();
          }
          operationStack.pollLast();
          break;
        case ' ':
          break;
        case '+':
        case '-':
          if (i == 0 || s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-') {
            numStack.addLast(0);
          }
          while (!operationStack.isEmpty() && operationStack.peekLast() != '(') {
            calculateHelper();
          }
          operationStack.addLast(c);
          break;
        default:
          int j = i, num = c - '0';
          while (j + 1 < s.length() && Character.isDigit(s.charAt(j + 1))) {
            num = num * 10 + s.charAt(j + 1) - '0';
            j++;
          }
          // [i, j] 是数字
          i = j;
          numStack.addLast(num);
      }
    }
    calculateHelper();
    return numStack.pollLast();
  }

  private void calculateHelper() {
    if (numStack.size() < 2 || operationStack.isEmpty()) {
      return;
    }
    int num1 = numStack.pollLast(), num2 = numStack.pollLast();
    numStack.addLast(operationStack.pollLast() == '+' ? (num2 + num1) : (num2 - num1));
  }

}