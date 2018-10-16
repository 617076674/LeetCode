package question079;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81623607
 */
public class Solution {

    boolean[][] flag;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m == 0){
            return word.length() == 0;
        }
        int n = board[0].length;
        flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)){
                    flag[i][j] = true;
                    if(exist(board, word, 1, i, j)){
                        return true;
                    }
                    flag[i][j] = false;
                }
            }
        }
        return false;
    }

    //We have found [0, index] of word in board, trying to find index + 1.
    //Now we are in (x, y)
    private boolean exist(char[][] board, String word, int index, int x, int y){
        if(index == word.length()){
            return true;
        }
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if(newX >=0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if(!flag[newX][newY] && board[newX][newY] == word.charAt(index)){
                    flag[newX][newY] = true;
                    if(exist(board, word, index + 1, newX, newY)){
                        return true;
                    }
                    flag[newX][newY] = false;
                }
            }
        }
        return false;
    }
}
