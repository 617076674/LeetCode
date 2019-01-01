package question130;

public class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if(board[i][j] == 'O' && !visited[i][j]) {  //对边界上的'O'进行深度优先遍历
                        dfs(board, i, j, visited);
                    }
                }
            }
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if(!visited[i][j] && board[i][j] == 'O') {  //如果该'O'不和边界上的'O'相连通，就需要被填充为'X'
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int newi = i + directions[k][0];
            int newj = j + directions[k][1];
            if(isValid(board, newi, newj) && !visited[newi][newj] && board[newi][newj] == 'O') {
                dfs(board, newi, newj, visited);
            }
        }
    }

    private boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
