package question0999_available_captures_for_rook;

/**
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37MB，击败5.11%。
 */
public class Solution {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int result = 0;
                    //往北走
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'B') {
                            break;
                        } else if (board[k][j] == 'p') {
                            result++;
                            break;
                        }
                    }
                    //往东走
                    for (int k = j + 1; k < 8; k++) {
                        if (board[i][k] == 'B') {
                            break;
                        } else if (board[i][k] == 'p') {
                            result++;
                            break;
                        }
                    }
                    //往南走
                    for (int k = i + 1; k < 8; k++) {
                        if (board[k][j] == 'B') {
                            break;
                        } else if (board[k][j] == 'p') {
                            result++;
                            break;
                        }
                    }
                    //往西走
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'B') {
                            break;
                        } else if (board[i][k] == 'p') {
                            result++;
                            break;
                        }
                    }
                    return result;
                }
            }
        }
        return 0;
    }
}