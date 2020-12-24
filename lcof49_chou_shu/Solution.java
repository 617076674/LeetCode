package lcof49_chou_shu;

public class Solution {

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int num2 = 0, num3 = 0, num5 = 0;
        for (int i = 1; i < n; i++) {
            int nextNum2 = dp[num2] * 2, nextNum3 = dp[num3] * 3, nextNum5 = dp[num5] * 5;
            dp[i] = Math.min(nextNum2, Math.min(nextNum3, nextNum5));
            if (nextNum2 == dp[i]) {
                num2++;
            }
            if (nextNum3 == dp[i]) {
                num3++;
            }
            if (nextNum5 == dp[i]) {
                num5++;
            }
        }
        return dp[n - 1];
    }

}