package contest.question1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return list;
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return list;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag1 = true, flag2 = true;
                for (int k = 0; k < m; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (matrix[k][j] > matrix[i][j]) {
                        flag1 = false;
                        break;
                    }
                }
                for (int k = 0; k < n; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (matrix[i][k] < matrix[i][j]) {
                        flag2 = false;
                        break;
                    }
                }
                if (flag1 && flag2) {
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }
}