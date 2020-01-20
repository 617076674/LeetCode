package question0348_design_tic_tac_toe;

public class TicTacToe {
    private int[][] graph;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        graph = new int[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        graph[row][col] = player;
        //判断第col列是否全部相同
        int i = 0;
        for (; i < graph.length; i++) {
            if (graph[i][col] != player) {
                break;
            }
        }
        if (i == graph.length) {
            return player;
        }
        //判断第row行是否全部相同
        int j = 0;
        for (; j < graph.length; j++) {
            if (graph[row][j] != player) {
                break;
            }
        }
        if (j == graph.length) {
            return player;
        }
        //判断正对角线是否全部相同
        int k = 0;
        for (; k < graph.length; k++) {
            if (graph[k][k] != player) {
                break;
            }
        }
        if (k == graph.length) {
            return player;
        }
        //判断反对角线是否全部相同
        int l = 0;
        for (; l < graph.length; l++) {
            if (graph[l][graph.length - 1 - l] != player) {
                break;
            }
        }
        if (l == graph.length) {
            return player;
        }
        return 0;
    }
}