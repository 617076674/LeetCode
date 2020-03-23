package question1380_lucky_numbers_in_a_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
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
            int minIndex = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < matrix[i][minIndex]) {
                    minIndex = j;
                }
            }
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (matrix[i][minIndex] < matrix[j][minIndex]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(matrix[i][minIndex]);
            }
        }
        return list;
    }
}