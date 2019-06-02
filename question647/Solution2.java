package question647;

public class Solution2 {

    public int countSubstrings(String s) {
        int count = 0, len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int i = -1; i > -len ; i--) {
            for (int j = 0; j < len + i; j++) {
                if (s.charAt(j) == s.charAt(j - i)) {
                    if (i == -1 || dp[j + 1][j - i - 1]) {
                        dp[j][j - i] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
