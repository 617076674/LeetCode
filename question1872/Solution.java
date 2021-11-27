package question1872;

public class Solution {

  private int[] sums;

  private int n;

  private Integer[] memo;

  public int stoneGameVIII(int[] stones) {
    sums = new int[stones.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + stones[i - 1];
    }
    n = stones.length;
    memo = new Integer[stones.length];
    return stoneGameVIIIHelper(1);
  }

  // 在 [i, stones.length - 1] 范围内选择一个下标，所能获得的最大分数是多少
  private int stoneGameVIIIHelper(int i) {
    if (i == n - 1) {
      return sums[n];
    }
    if (memo[i] != null) {
      return memo[i];
    }
    memo[i] = Math.max(stoneGameVIIIHelper(i + 1), sums[i + 1] - stoneGameVIIIHelper(i + 1));
    return memo[i];
  }

}