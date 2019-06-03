package question312;

public class Solution2 {

    int[][] dp;
    int[] temp;

    public int maxCoins(int[] nums) {
        int len = nums.length;
        temp = new int[len + 2];
        temp[0] = temp[len + 1] = 1;
        for (int i = 1; i < len + 1; i++) {
            temp[i] = nums[i - 1];
        }
        dp = new int[len + 2][len + 2];
        return maxCoins(1, len);
    }

    private int maxCoins(int left, int right) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        }
        for (int i = left; i <= right; i++) {
            dp[left][right] = Math.max(temp[i] * temp[left - 1] * temp[right + 1] + maxCoins(i + 1, right) + maxCoins(left, i - 1), dp[left][right]);
        }
        return dp[left][right];
    }

}
