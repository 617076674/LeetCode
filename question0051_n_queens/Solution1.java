package question0051_n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯法。
 *
 * 执行用时：16ms，击败11.17%。消耗内存：39.9MB，击败14.72%。
 */
public class Solution1 {
    private List<List<String>> listList = new ArrayList<>();

    private int[] position;

    public List<List<String>> solveNQueens(int n) {
        boolean[][] visited = new boolean[n][n];
        position = new int[n];
        solveNQueens(0, n, visited);
        return listList;
    }

    private void solveNQueens(int m, int n, boolean[][] visited) {
        if (m == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (position[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            listList.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[m][i]) {
                position[m] = i;
                boolean[][] tmpVisited = new boolean[n][n];
                for (int j = 0; j < n; j++) {
                    tmpVisited[j] = Arrays.copyOf(visited[j], n);
                }
                for (int j = 0; j < n; j++) {
                    tmpVisited[j][i] = tmpVisited[m][j] = true;
                    for (int k = 0; k < n; k++) {
                        if ((Math.abs(j - m) == Math.abs(k - i))) {
                            tmpVisited[j][k] = true;
                        }
                    }
                }
                solveNQueens(m + 1, n, tmpVisited);
                position[m] = -1;
            }
        }
    }
}