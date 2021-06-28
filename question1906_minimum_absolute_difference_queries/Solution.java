package question1906_minimum_absolute_difference_queries;

public class Solution {

  public int[] minDifference(int[] nums, int[][] queries) {
    int[][] pre = new int[nums.length + 1][101];
    // pre[i][j] 表示 nums 数组中 [0, i - 1] 范围内数字 j 出现的次数
    for (int i = 1; i < pre.length; i++) {
      System.arraycopy(pre[i - 1], 1, pre[i], 1, 100);
      pre[i][nums[i - 1]]++;
    }
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int left = queries[i][0], right = queries[i][1];
      Integer last = null;
      int temp = Integer.MAX_VALUE;
      for (int j = 1; j <= 100; j++) {
        if (pre[right + 1][j] - pre[left][j] > 0) {
          if (last != null) {
            temp = Math.min(temp, j - last);
          }
          last = j;
        }
      }
      result[i] = temp == Integer.MAX_VALUE ? -1 : temp;
    }
    return result;
  }

}