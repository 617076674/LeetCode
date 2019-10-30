package question0036_valid_sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82585501
 *
 * 一次遍历，在遍历数组中每一个元素的时候同时更新九宫格中每一个元素对应列、对应行、对应3 * 3宫中的信息。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：2ms，击败98.54%。消耗内存：41.8MB，击败84.41%。
 */
public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        List<int[]> rowFlags = new ArrayList<>(), columnFlags = new ArrayList<>(), palaceFlags = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rowFlags.add(new int[9]);
            columnFlags.add(new int[9]);
            palaceFlags.add(new int[9]);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char tmp = board[i][j];
                if (tmp == '.') {
                    continue;
                }
                if (rowFlags.get(i)[tmp - '0' - 1] == 1) {
                    return false;
                } else {
                    rowFlags.get(i)[tmp - '0' - 1] = 1;
                }
                if (columnFlags.get(j)[tmp - '0' - 1] == 1) {
                    return false;
                } else {
                    columnFlags.get(j)[tmp - '0' - 1] = 1;
                }
                if (palaceFlags.get((i / 3) * 3 + j / 3)[tmp - '0' - 1] == 1) {
                    return false;
                } else {
                    palaceFlags.get((i / 3) * 3 + j / 3)[tmp - '0' - 1] = 1;
                }
            }
        }
        return true;
    }
}