package question174;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] hp = new int[m][n];
        hp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        for(int i = m - 2; i >= 0; i--){
            int temp = hp[i + 1][n - 1] - dungeon[i][n - 1];
            hp[i][n - 1] = temp <= 0 ? 1 : temp;
        }
        for(int i = n - 2; i >= 0; i--){
            int temp = hp[m - 1][i + 1] - dungeon[m - 1][i];
            hp[m - 1][i] = temp <= 0 ? 1 : temp;
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                int temp = Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j];
                hp[i][j] = temp <= 0 ? 1 : temp;
            }
        }
        return hp[0][0];
    }
}
