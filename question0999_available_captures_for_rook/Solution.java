package question0999_available_captures_for_rook;

/**
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37MB，击败5.11%。
 */
public class Solution {
    public int numRookCaptures(char[][] board) {
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int result = 0;
                    for (int k = 0; k < 4; k++) {
                        int newI = i + directions[k][0], newJ = j + directions[k][1];
                        while (newI >= 0 && newI < 8 && newJ >= 0 && newJ < 8) {
                            if (board[newI][newJ] == 'B') {
                                break;
                            } else if (board[newI][newJ] == 'p') {
                                result++;
                                break;
                            }
                            newI += directions[k][0];
                            newJ += directions[k][1];
                        }
                    }
                    return result;
                }
            }
        }
        return 0;
    }
}