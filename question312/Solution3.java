package question312;

public class Solution3 {

    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 2];
        temp[0] = temp[len + 1] = 1;
        for (int i = 1; i < len + 1; i++) {
            temp[i] = nums[i - 1];
        }
        int[][] dp = new int[len + 2][len + 2];
        for (int k = 1; k <= len; k++) {
            for (int i = 1; i <= len - k + 1; i++) {
                int j = i + k - 1;
                for (int p = i; p <= j; p++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][p - 1] + dp[p + 1][j] + temp[i - 1] * temp[p] * temp[j + 1]);
                }
            }
        }
        return dp[1][len];
    }

}
