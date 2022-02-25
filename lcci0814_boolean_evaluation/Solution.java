package lcci0814_boolean_evaluation;

public class Solution {

  private Integer[][][] memo;

  public int countEval(String s, int result) {
    memo = new Integer[s.length()][s.length()][2];
    return countEvalHelper(s, result, 0, s.length() - 1);
  }

  private int countEvalHelper(String s, int result, int left, int right) {
    if (left == right) {
      if (result == 0) {
        if (s.charAt(left) == '0') {
          return 1;
        }
        return 0;
      }
      if (s.charAt(left) == '1') {
        return 1;
      }
      return 0;
    }
    if (null != memo[left][right][result]) {
      return memo[left][right][result];
    }
    int res = 0;
    for (int i = left + 1; i <= right - 1; i += 2) {
      char c = s.charAt(i);
      if (result == 0) {
        switch (c) {
          case '&':
            // 0 & 0 或 0 & 1 或 1 & 0
            res += countEvalHelper(s, 0, left, i - 1) * (countEvalHelper(s, 0, i + 1, right) + countEvalHelper(s, 1, i + 1, right)) + countEvalHelper(s, 1, left, i - 1) * countEvalHelper(s, 0, i + 1, right);
            break;
          case '|':
            // 0 | 0
            res += countEvalHelper(s, 0, left, i - 1) * countEvalHelper(s, 0, i + 1, right);
            break;
          case '^':
            // 1 ^ 1 或 0 ^ 0
            res += countEvalHelper(s, 1, left, i - 1) * countEvalHelper(s, 1, i + 1, right) + countEvalHelper(s, 0, left, i - 1) * countEvalHelper(s, 0, i + 1, right);
          default:
        }
      } else {
        switch (c) {
          case '|':
            // 1 | 1 或 0 | 1 或 1 | 0
            res += countEvalHelper(s, 1, left, i - 1) * (countEvalHelper(s, 0, i + 1, right) + countEvalHelper(s, 1, i + 1, right)) + countEvalHelper(s, 0, left, i - 1) * countEvalHelper(s, 1, i + 1, right);
            break;
          case '&':
            // 1 & 1
            res += countEvalHelper(s, 1, left, i - 1) * countEvalHelper(s, 1, i + 1, right);
            break;
          case '^':
            // 0 ^ 1 或 1 ^ 0
            res += countEvalHelper(s, 1, left, i - 1) * countEvalHelper(s, 0, i + 1, right) + countEvalHelper(s, 0, left, i - 1) * countEvalHelper(s, 1, i + 1, right);
          default:
        }
      }
    }
    memo[left][right][result] = res;
    return res;
  }

}