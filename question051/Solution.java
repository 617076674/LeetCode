package question051;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82781370
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    List<List<String>> listList;

    public List<List<String>> solveNQueens(int n) {
        listList = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        solveNQueens(new HashMap<>(), 0, n, visited);
        return listList;
    }

    /*
     * hashMap-------The queen in row key is in column value
     * we are going to put the mth queen
     * n represents the total quantity of the queen
     */
    private void solveNQueens(HashMap<Integer, Integer> hashMap, int m, int n, boolean[][] visited) {
        if (m == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String string = "";
                for (int j = 0; j < n; j++) {
                    if (hashMap.containsKey(i) && hashMap.get(i) == j) {
                        string += "Q";
                    } else {
                        string += ".";
                    }
                }
                list.add(string);
            }
            listList.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[m][i]) {
                hashMap.put(m, i);
                boolean[][] tempVisited = new boolean[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        tempVisited[j][k] = visited[j][k];
                    }
                }
                for (int j = 0; j < n; j++) {
                    tempVisited[j][hashMap.get(m)] = true;
                    tempVisited[m][j] = true;
                    for (int k = 0; k < n; k++) {
                        if ((Math.abs(j - m) == Math.abs(k - hashMap.get(m)))) {
                            tempVisited[j][k] = true;
                        }
                    }
                }
                solveNQueens(hashMap, m + 1, n, tempVisited);
                hashMap.remove(m);
            }
        }
    }
}
