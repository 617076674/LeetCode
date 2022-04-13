package question2212;

import java.util.Arrays;

public class Solution {

  private boolean[] getScore = new boolean[12];

  private int maxScore = 0;

  private int numArrows;

  private int[] aliceArrows;

  private int[] bobArrows;

  public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
    this.numArrows = numArrows;
    this.aliceArrows = aliceArrows;
    dfs(0);
    return bobArrows;
  }

  private int[] check() {
    int[] result = new int[12];
    int sum = 0;
    for (int i = 0; i < getScore.length; i++) {
      if (getScore[i]) {
        sum += aliceArrows[i] + 1;
        result[i] = aliceArrows[i] + 1;
      }
    }
    if (sum <= numArrows) {
      result[0] += numArrows - sum;
      return result;
    }
    return null;
  }

  private int getTotalScore() {
    int sum = 0;
    for (int i = 0; i < getScore.length; i++) {
      if (getScore[i]) {
        sum += i;
      }
    }
    return sum;
  }

  private void dfs(int index) {
    if (index == 12) {
      int[] checkResult = check();
      if (null == checkResult) {
        return;
      }
      if (getTotalScore() > maxScore) {
        maxScore = getTotalScore();
        bobArrows = checkResult;
      }
      return;
    }
    // 得分
    getScore[index] = true;
    dfs(index + 1);
    // 不得分
    getScore[index] = false;
    dfs(index + 1);
  }

}