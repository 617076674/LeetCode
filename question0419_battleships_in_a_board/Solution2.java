package question0419_battleships_in_a_board;

/**
 * 判断每一个X是否是一艘新战舰时，判断其上方或左方的值是否是X。
 *
 * 时间复杂度是O(mn)，其中m是board的行数，n是board的列数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：51.3MB，击败5.02%。
 */
public class Solution2 {
    public int countBattleships(char[][] board) {
        int m;
        if (null == board || (m = board.length) == 0) {
            return 0;
        }
        int n;
        if (null == board[0] || (n = board[0].length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && !(i > 0 && board[i - 1][j] == 'X') && !(j > 0 && board[i][j - 1] == 'X')) {
                    result++;
                }
            }
        }
        return result;
    }
}