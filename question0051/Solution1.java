package question0051;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82781370
 */

import java.util.ArrayList;
import java.util.List;

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
                boolean[][] tempVisited = new boolean[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        tempVisited[j][k] = visited[j][k];
                    }
                }
                for (int j = 0; j < n; j++) {
                    tempVisited[j][i] = true;
                    tempVisited[m][j] = true;
                    for (int k = 0; k < n; k++) {
                        if ((Math.abs(j - m) == Math.abs(k - i))) {
                            tempVisited[j][k] = true;
                        }
                    }
                }
                solveNQueens(m + 1, n, tempVisited);
                position[m] = -1;
            }
        }
    }
}
