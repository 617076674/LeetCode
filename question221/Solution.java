package question221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int m = matrix.length;
        if(0 == m){
            return result;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
            }else{
                dp[0][i] = 0;
            }
            result = Math.max(result, dp[0][i]);
        }
        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
            }else{
                dp[i][0] = 0;
            }
            result = Math.max(result, dp[i][0]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    int temp = (int) Math.sqrt(dp[i - 1][j - 1]);
                    if(0 == temp){
                        dp[i][j] = 1;
                    }else{
                        int p = i - 1;
                        for(; p >= i - temp; p--){
                            if(matrix[p][j] == '0'){
                                break;
                            }
                        }
                        int q = j - 1;
                        for(; q >= j - temp; q--){
                            if(matrix[i][q] == '0'){
                                break;
                            }
                        }
                        int min = Math.min(i - p, j - q);
                        dp[i][j] = (int) Math.pow(min, 2);
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
