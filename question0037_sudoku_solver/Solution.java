package question0037_sudoku_solver;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * 回溯法。
 *
 * 执行用时：9ms，击败64.47%。消耗内存：35.4MB，击败70.78%。
 */
public class Solution {
    private List<Integer> list = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    list.add(i * 10 + j);
                }
            }
        }
        try {
            fillNumber(board, 0);
        } catch (Exception e) {}
    }

    private void fillNumber(char[][] board, int index) {
        if (index == list.size()) {
            throw new RuntimeException();   //利用异常来跳出该函数
        }
        int i = list.get(index) / 10, j = list.get(index) % 10;
        for (int num = 1; num <= 9; num++) {
            if (canFillThisNum(board, i, j, num)) {
                board[i][j] = (char) (num + '0');
                fillNumber(board, index + 1);
                board[i][j] = '.';  //变量的回溯
            }
        }
    }

    private boolean canFillThisNum(char[][] board, int x, int y, int num) {
        if (board[x][y] != '.') {
            return false;
        }
        for (int k = 0; k < 9; k++) {
            if (num == board[x][k] - '0') {
                return false;
            }
            if (num == board[k][y] - '0') {
                return false;
            }
        }
        int top = (x / 3) * 3, bottom = top + 2, left = (y / 3) * 3, right = left + 2;
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (num == board[i][j] - '0') {
                    return false;
                }
            }
        }
        return true;
    }
}