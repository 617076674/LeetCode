package question1582_special_positions_in_a_binary_matrix;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numSpecial(int[][] mat) {
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            int sum = 0, index = -1;
            for (int j = 0; j < mat[0].length; j++) {
                sum += mat[i][j];
                if (mat[i][j] == 1) {
                    index = j;
                }
            }
            if (sum == 1) {
                int tmp = 0;
                for (int j = 0; j < mat.length; j++) {
                    tmp += mat[j][index];
                }
                if (tmp == 1) {
                    result++;
                }
            }
        }
        return result;
    }

}