package question1289_minimum_falling_path_sum_ii;

/**
 * 对 Solution1 进行改进，记录前一行的最小值和次小值，降低时间复杂度为 O(n ^ 2)。
 *
 * 执行用时：5ms，击败61.38%。消耗内存：46.3MB，击败55.17%。
 */
public class Solution2 {
  public int minFallingPathSum(int[][] arr) {
    int n = arr.length;
    int[][] dp = new int[n][n];
    for (int j = 0; j < n; j++) {
      dp[0][j] = arr[0][j];
    }
    int[] min1AndMin2 = findMin1AndMin2(dp[0]);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        if (j == min1AndMin2[0]) {
          dp[i][j] = Math.min(dp[i][j], arr[i][j] + dp[i - 1][min1AndMin2[1]]);
        } else {
          dp[i][j] = Math.min(dp[i][j], arr[i][j] + dp[i - 1][min1AndMin2[0]]);
        }
      }
      min1AndMin2 = findMin1AndMin2(dp[i]);
    }
    int result = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      result = Math.min(dp[n - 1][j], result);
    }
    return result;
  }

  private int[] findMin1AndMin2(int[] nums) {
    int[] result = {0, -1};
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < nums[result[0]]) {
        result[0] = i;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (i != result[0] && (result[1] == -1 || nums[i] < nums[result[1]])) {
        result[1] = i;
      }
    }
    return result;
  }
}