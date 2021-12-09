package question2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

  private List<Integer> numList = new ArrayList<>();

  private List<Character> operationList = new ArrayList<>();

  public int scoreOfStudents(String s, int[] answers) {
    int realResult = calculateReal(s);
    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        numList.add(s.charAt(i) - '0');
      } else {
        operationList.add(s.charAt(i));
      }
    }
    Set<Integer> set = calculate(0, numList.size() - 1);
    int total = 0;
    for (int answer : answers) {
      if (answer == realResult) {
        total += 5;
      } else if (set.contains(answer)) {
        total += 2;
      }
    }
    return total;
  }

  private static int calculateReal(String s) {
    LinkedList<Integer> numStack = new LinkedList<>();
    LinkedList<Integer> operationStack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        numStack.addLast(c - '0');
      } else if (c == '*') {
        while (!operationStack.isEmpty() && operationStack.peekLast() == '*') {
          calculate(numStack, operationStack, s);
        }
        operationStack.addLast(i);
      } else {
        while (!operationStack.isEmpty()) {
          calculate(numStack, operationStack, s);
        }
        operationStack.addLast(i);
      }
    }
    while (!operationStack.isEmpty()) {
      calculate(numStack, operationStack, s);
    }
    return numStack.pollLast();
  }

  private static void calculate(LinkedList<Integer> numStack,
                                LinkedList<Integer> operationStack, String s) {
    if (numStack.size() < 2 || operationStack.isEmpty()) {
      return;
    }
    int num1 = numStack.pollLast(), num2 = numStack.pollLast();
    numStack.addLast(s.charAt(operationStack.pollLast()) == '+' ? (num2 + num1) : (num2 * num1));
  }

  private Set<Integer>[][] memo = new HashSet[20][20];

  private Set<Integer> calculate(int numLeft, int numRight) {
    if (null != memo[numLeft][numRight]) {
      return memo[numLeft][numRight];
    }
    Set<Integer> result = new HashSet<>();
    if (numLeft == numRight) {
      result.add(numList.get(numLeft));
      memo[numLeft][numRight] = result;
      return result;
    }
    for (int i = numLeft; i < numRight; i++) {
      Set<Integer> leftResult = calculate(numLeft, i);
      Set<Integer> rightResult = calculate(i + 1, numRight);
      if (operationList.get(i) == '+') {
        for (int leftResultNum : leftResult) {
          for (int rightResultNum : rightResult) {
            int temp = leftResultNum + rightResultNum;
            if (temp <= 1000) {
              result.add(temp);
            }
          }
        }
      } else {
        for (int leftResultNum : leftResult) {
          for (int rightResultNum : rightResult) {
            int temp = leftResultNum * rightResultNum;
            if (temp <= 1000) {
              result.add(temp);
            }
          }
        }
      }
    }
    memo[numLeft][numRight] = result;
    return result;
  }

}