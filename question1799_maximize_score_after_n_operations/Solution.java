package question1799_maximize_score_after_n_operations;

public class Solution {

  private int[][] gcd;

  private Integer[][] memo = new Integer[9][1 << 14];

  public int maxScore(int[] nums) {
    gcd = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        gcd[i][j] = getGCD(nums[i], nums[j]);
      }
    }
    return getScore(nums, 1, 0);
  }

  private int getScore(int[] nums, int i, int status) {
    if (null != memo[i][status]) {
      return memo[i][status];
    }
    int score = 0;
    for (int j = 0; j < nums.length; j++) {
      if ((status & (1 << j)) != 0) {
        continue;
      }
      status |= (1 << j);
      for (int k = j + 1; k < nums.length; k++) {
        if ((status & (1 << k)) != 0) {
          continue;
        }
        status |= (1 << k);
        score = Math.max(score, getScore(nums, i + 1, status) + i * gcd[j][k]);
        status &= ~(1 << k);
      }
      status &= ~(1 << j);
    }
    memo[i][status] = score;
    return score;
  }

  private int getGCD(int a, int b) {
    if (b == 0) {
      return a;
    }
    return getGCD(b, a % b);
  }

}