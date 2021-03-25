package question0150_evaluate_reverse_polish_notation;

import java.util.LinkedList;

public class Solution {

  public int evalRPN(String[] tokens) {
    LinkedList<Integer> stack = new LinkedList<>();
    for (String string : tokens) {
      switch (string) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          stack.push(-stack.pop() + stack.pop());
          break;
        case "*":
          stack.push(stack.pop() * stack.pop());
          break;
        case "/":
          Integer num1 = stack.pop();
          Integer num2 = stack.pop();
          stack.push(num2 / num1);
          break;
        default:
          stack.push(Integer.parseInt(string));
      }
    }
    return stack.pop();
  }

}