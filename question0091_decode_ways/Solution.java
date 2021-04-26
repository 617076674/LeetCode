package question0091_decode_ways;

public class Solution {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1]; // dp[i] 表示 [0, i - 1] 范围内的解码总数
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 2) - '0' <= 2) {
                if (s.charAt(i - 2) == '2') {
                    if (s.charAt(i - 1) - '0' <= 6) {
                        dp[i] = dp[i - 2];
                        if (s.charAt(i - 1) != '0') {
                            dp[i] += dp[i - 1];
                        }
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else if (s.charAt(i - 2) == '1') {
                    dp[i] = dp[i - 2];
                    if (s.charAt(i - 1) != '0') {
                        dp[i] += dp[i - 1];
                    }
                } else {
                    if (s.charAt(i - 1) != '0') {
                        dp[i] = dp[i - 1];
                    }
                }
            } else {
                if (s.charAt(i - 1) != '0') {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

}