package question1406_stone_game_iii;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 stoneValue 数组的长度。
 *
 * 执行用时：77ms，击败9.50%。消耗内存：58.8MB，击败7.32%。
 */
public class Solution {
  private int[] sums;

  private int n;

  private Integer[] memo;

  public String stoneGameIII(int[] stoneValue) {
    n = stoneValue.length;
    sums = new int[n];
    sums[n - 1] = stoneValue[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      sums[i] = sums[i + 1] + stoneValue[i];
    }
    memo = new Integer[n];
    int num = stoneGameIIIHelper(stoneValue, 0);
    if (sums[0] - num < num) {
      return "Alice";
    } else if (sums[0] - num == num) {
      return "Tie";
    }
    return "Bob";
  }

  private int stoneGameIIIHelper(int[] stoneValue, int index) {
    if (index >= stoneValue.length) {
      return 0;
    }
    if (null != memo[index]) {
      return memo[index];
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < Math.min(n - index, 3); i++) {
      if (i + index + 1 < n) {
        result = Math.max(result, sums[index] - stoneGameIIIHelper(stoneValue, i + index + 1));
      } else {
        result = Math.max(result, sums[index]);
      }
    }
    memo[index] = result;
    return result;
  }
}