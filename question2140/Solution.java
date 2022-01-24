package question2140;

public class Solution {

  private Long[] memo;

  public long mostPoints(int[][] questions) {
    memo = new Long[questions.length];
    return mostPointsHelper(questions, 0);
  }

  private long mostPointsHelper(int[][] questions, int begin) {
    if (begin >= questions.length) {
      return 0L;
    }
    if (null != memo[begin]) {
      return memo[begin];
    }
    long result = Math.max(questions[begin][0] + mostPointsHelper(questions, begin + 1 + questions[begin][1]), mostPointsHelper(questions, begin + 1));
    memo[begin] = result;
    return result;
  }

}