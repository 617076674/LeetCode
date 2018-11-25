package question115;

public class Solution {
    public int numDistinct(String s, String t) {
        int lenX = t.length();
        int lenY = s.length();
        if(lenY == 0){
            return 0;
        }
        int[][] dp = new int[lenX][lenY];
        if(t.charAt(0) == s.charAt(0)){
            dp[0][0] = 1;
        }else{
            dp[0][0] = 0;
        }
        for(int i = 1; i < lenY; i++){
            if(s.charAt(i) == t.charAt(0)){
                dp[0][i] = dp[0][i - 1] + 1;
            }else{
                dp[0][i] = dp[0][i - 1];
            }
        }
        for(int i = 1; i < lenX; i++){
            for(int j = 0; j < lenY; j++){
                if(i > j){
                    dp[i][j] = 0;
                }else{
                    if(t.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[lenX - 1][lenY - 1];
    }
}
