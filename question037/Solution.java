package question037;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81660151
 */
public class Solution {

    private char[][] retBoard = new char[9][9];

    private class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void solveSudoku(char[][] board) {
        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    arrayList.add(new Point(i, j));
            }
        }
        fillNumber(board, arrayList, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = retBoard[i][j];
            }
        }
    }

    private void fillNumber(char[][] board, ArrayList<Point> arrayList, int index) {
        if (index == arrayList.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    retBoard[i][j] = board[i][j];
                }
            }
            return;
        }
        int indexi = arrayList.get(index).i;
        int indexj = arrayList.get(index).j;
        for (int num = 1; num <= 9; num++) {
            if (canFillThisNum(board, indexi, indexj, num)) {
                board[indexi][indexj] = String.valueOf(num).charAt(0);
                fillNumber(board, arrayList, index + 1);
                board[indexi][indexj] = '.';
            }
        }
    }

    private boolean canFillThisNum(char[][] board, int i, int j, int num) {
        if (board[i][j] != '.') {
            return false;
        }
        HashSet<Character> hashSet = new HashSet<>();
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') {
                hashSet.add(board[i][k]);
            }
            if (board[k][j] != '.') {
                hashSet.add(board[k][j]);
            }
        }
        for (int k = (i / 3) * 3; k <= (i / 3) * 3 + 2; k++) {
            for (int p = (j / 3) * 3; p <= (j / 3) * 3 + 2; p++) {
                if (board[k][p] != '.') {
                    hashSet.add(board[k][p]);
                }
            }
        }
        if (hashSet.contains(String.valueOf(num).charAt(0))) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] stringBoard = {{"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = stringBoard[i][j].charAt(0);
            }
        }

        System.out.println("����ǰ��");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        new Solution().solveSudoku(board);
        System.out.println("�����");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
