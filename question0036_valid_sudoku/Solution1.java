package question0036_valid_sudoku;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82585501
 *
 * 暴力破解法。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：2ms，击败98.54%。消耗内存：42.8MB，击败78.44%。
 */
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        //1-确保每一行有效
        for (int i = 0; i < 9; i++) {
            int[] flags = new int[9];
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, flags, i, j)) {
                    return false;
                }
            }
        }
        //2-确保每一列有效
        for (int i = 0; i < 9; i++) {
            int[] flags = new int[9];
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, flags, j, i)) {
                    return false;
                }
            }
        }
        //3-确保每一个九宫格有效
        for (int p = 0; p <= 6; p += 3) {
            for (int k = 0; k <= 6; k += 3) {
                int[] flags = new int[9];
                for (int i = p; i < p + 3; i++) {
                    for (int j = k; j < k + 3; j++) {
                        if (!isValid(board, flags, i, j)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int[] flags, int i, int j) {
        char tmp = board[i][j];
        if (tmp != '.') {
            if (flags[tmp - '0' - 1] == 1) {
                return false;
            } else {
                flags[tmp - '0' - 1] = 1;
            }
        }
        return true;
    }
}