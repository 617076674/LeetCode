package question1884_egg_drop_with_2_eggs_and_n_floors;

public class Solution2 {

  public int twoEggDrop(int n) {
    memo = new int[3][n + 1];
    return twoEggDropHelper(2, n);
  }

  private int[][] memo;

  private int twoEggDropHelper(int k, int n) {
    if (k == 1 || n < 2) {
      return n;
    }
    if (memo[k][n] != 0) {
      return memo[k][n];
    }
    int left = 1, right = n;
    memo[k][n] = Integer.MAX_VALUE;
    while (left <= right) {
      int mid = left + ((right - left) >> 1), broken = twoEggDropHelper(k - 1, mid - 1), notBroken = twoEggDropHelper(k, n - mid);
      if (broken > notBroken) {
        right = mid - 1;
        memo[k][n] = Math.min(memo[k][n], broken + 1);
      } else {
        left = mid + 1;
        memo[k][n] = Math.min(memo[k][n], notBroken + 1);
      }
    }
    return memo[k][n];
  }

}