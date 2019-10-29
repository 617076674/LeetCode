package question036_valid_sudoku;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82585501
 */
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        //to ensure every row is valid
        for (int i = 0; i < 9; i++) {
            int[] flags = new int[9];
            for (int j = 0; j < 9; j++) {
                char tmp = board[i][j];
                if (tmp != '.') {
                    if (flags[tmp - '0' - 1] == 1) {
                        return false;
                    } else {
                        flags[tmp - '0' - 1] = 1;
                    }
                }
            }
        }
        //to ensure every column is valid
        for (int j = 0; j < 9; j++) {
            int[] flags = new int[9];
            for (int i = 0; i < 9; i++) {
                char tmp = board[i][j];
                if (tmp != '.') {
                    if (flags[tmp - '0' - 1] == 1) {
                        return false;
                    } else {
                        flags[tmp - '0' - 1] = 1;
                    }
                }
            }
        }
        //to ensure every 3*3 palace is valid
        for (int p = 0; p <= 6; p += 3) {
            for (int k = 0; k <= 6; k += 3) {
                int[] flags = new int[9];
                for (int i = p; i < p + 3; i++) {
                    for (int j = k; j < k + 3; j++) {
                        char tmp = board[i][j];
                        if (tmp != '.') {
                            if (flags[tmp - '0' - 1] == 1) {
                                return false;
                            } else {
                                flags[tmp - '0' - 1] = 1;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}