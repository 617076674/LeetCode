package question212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * question079的升级版，回溯法。
 * <p>
 * 时间复杂度是O(mnkp)，其中m是board数组的行数，n是board数组的列数，k是words中字符串的长度，p是words数组的长度。
 * <p>
 * 执行用时：711ms，击败11.64%。消耗内存：44.8MB，击败93.58%。
 */
public class Solution1 {

    private boolean[][] flag;

    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int m;  //board数组的行数

    private int n;  //board数组的列数

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (exist(board, words[i])) {
                result.add(words[i]);
            }
        }
        return new ArrayList<>(result);
    }

    private boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return word.length() == 0;
        }
        n = board[0].length;
        flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag[i][j] = true;
                    if (exist(board, word, 1, i, j)) {
                        return true;
                    }
                    flag[i][j] = false;
                }
            }
        }
        return false;
    }

    /**
     * 该递归函数的定义是：我们现在在位置(x, y)处，需要寻找word中索引为index的字符
     */
    private boolean exist(char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                if (!flag[newX][newY] && board[newX][newY] == word.charAt(index)) {
                    flag[newX][newY] = true;
                    if (exist(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                    flag[newX][newY] = false;
                }
            }
        }
        return false;
    }

}
