package question1861_rotating_the_box;

import java.util.Arrays;

public class Solution {

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        int[] right = new int[m];
        Arrays.fill(right, n - 1);
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][right[i]] = '#';
                    right[i]--;
                } else if (box[i][j] == '*') {
                    right[i] = j - 1;
                }
            }
        }
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = box[m - i - 1][j];
            }
        }
        return result;
    }

}