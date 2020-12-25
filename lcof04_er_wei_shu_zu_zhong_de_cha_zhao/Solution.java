package lcof04_er_wei_shu_zu_zhong_de_cha_zhao;

public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n;
        if (null == matrix || (n = matrix.length) == 0) {
            return false;
        }
        int m;
        if (null == matrix[0] || (m = matrix[0].length) == 0) {
            return false;
        }
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

}