package question1896;

import java.util.LinkedList;

/**
 * 参考 LeetCode 224
 */
public class Solution {

  private LinkedList<int[]> numStack = new LinkedList<>();

  private LinkedList<Character> operationStack = new LinkedList<>();

  public int minOperationsToFlip(String expression) {
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      switch (c) {
        case '(':
          operationStack.addLast(c);
          break;
        case '&':
        case '|':
          while (!operationStack.isEmpty() && operationStack.peekLast() != '(') {
            calculate();
          }
          operationStack.addLast(c);
          break;
        case ')':
          while (!operationStack.isEmpty() && operationStack.peekLast() != '(') {
            calculate();
          }
          operationStack.pollLast();
          break;
        case '0':
          numStack.add(new int[] {0, 1});
          break;
        default:
          numStack.add(new int[] {1, 0});
      }
    }
    calculate();
    int[] status = numStack.pollLast();
    return Math.max(status[0], status[1]);
  }

  private void calculate() {
    if (numStack.size() < 2 || operationStack.isEmpty()) {
      return;
    }
    int[] status1 = numStack.pollLast(), status2 = numStack.pollLast();
    int[] orResult = orOperation(status1, status2), andResult = andOperation(status1, status2);
    if (operationStack.pollLast() == '&') {
      numStack.addLast(new int[] {Math.min(andResult[0], orResult[0] + 1), Math.min(andResult[1], orResult[1] + 1)});
    } else {
      numStack.addLast(new int[] {Math.min(andResult[0] + 1, orResult[0]), Math.min(andResult[1] + 1, orResult[1])});
    }
  }

  private static int[] orOperation(int[] status1, int[] status2) {
    int[] result = new int[2];
    result[0] = status1[0] + status2[0];
    result[1] = Math.min(status1[0] + status2[1], Math.min(status1[1] + status2[0],
        status1[1] + status2[1]));
    return result;
  }

  private static int[] andOperation(int[] status1, int[] status2) {
    int[] result = new int[2];
    result[0] = Math.min(status1[0] + status2[1], Math.min(status1[1] + status2[0],
        status1[0] + status2[0]));
    result[1] = status1[1] + status2[1];
    return result;
  }

}