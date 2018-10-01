package question072;

public class Solution {

    //dynamic programming
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] distances = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            distances[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            distances[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    distances[i][j] = distances[i - 1][j - 1];
                }else{
                    distances[i][j] = Math.min(distances[i - 1][j - 1], Math.min(distances[i - 1][j], distances[i][j - 1])) + 1;
                }
            }
        }

        return distances[m][n];
    }
}
