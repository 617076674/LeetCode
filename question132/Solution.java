package question132;

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] judge = new boolean[n][n];
        int[] dp = new int[n]; // dp[i]表示s中第i个字符到第（n-1）个字符所构成的子串的最小分割次数
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || judge[i + 1][j - 1])) {
                    judge[i][j] = true;
                    if (j + 1 < n) {
                        dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                    }else{
                        dp[i] = 0;
                    }
                }
            }
        }
        return dp[0];
    }
}

