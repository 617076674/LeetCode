package question1337_the_k_weakest_rows_in_a_matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 时间复杂度是O(mn)，其中m是矩阵mat的行数，n是矩阵mat的列数。空间复杂度是O(m)。
 *
 * 执行用时：3ms，击败71.58%。消耗内存：51.3MB，击败100.00%。
 */
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m;
        if (null == mat || (m = mat.length) == 0) {
            return null;
        }
        int n;
        if (null == mat[0] || (n = mat[0].length) == 0) {
            return null;
        }
        int[] countOne = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    countOne[i]++;
                } else {
                    break;
                }
            }
        }
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            indexList.add(i);
        }
        Collections.sort(indexList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (countOne[o1] == countOne[o2]) {
                    return o1 - o2;
                }
                return countOne[o1] - countOne[o2];
            }
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = indexList.get(i);
        }
        return result;
    }
}