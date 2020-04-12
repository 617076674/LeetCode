package question1260_shift_2d_grid;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：8ms，击败62.04%。消耗内存：40.3MB，击败79.69%。
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int m;
        if (null == grid || (m = grid.length) == 0) {
            return result;
        }
        int n;
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return result;
        }
        k %= m * n;
        List<Integer> row = new ArrayList<>();
        for (int i = m * n - k; i < m * n; i++) {
            row.add(grid[i / n][i % n]);
            if (row.size() == n) {
                result.add(row);
                row = new ArrayList<>();
            }
        }
        for (int i = 0; i < m * n - k; i++) {
            row.add(grid[i / n][i % n]);
            if (row.size() == n) {
                result.add(row);
                row = new ArrayList<>();
            }
        }
        return result;
    }
}