package question1744_can_you_eat_your_favorite_candy_on_your_favorite_day;

public class Solution {

  public boolean[] canEat(int[] candiesCount, int[][] queries) {
    boolean[] result = new boolean[queries.length];
    long[] sums = new long[candiesCount.length + 1];  // sums[i] 表示类型 [0, i - 1] 的糖果数目
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + candiesCount[i - 1];
    }
    for (int i = 0; i < queries.length; i++) {
      long min = queries[i][1] + 1, max = ((long) queries[i][1] + 1) * queries[i][2];
      // [min, max]
      // [sums[queries[i][0]] + 1, sums[queries[i][0] + 1]
      if (!(sums[queries[i][0]] + 1 > max || sums[queries[i][0] + 1] < min)) {
        result[i] = true;
      }
    }
    return result;
  }

}