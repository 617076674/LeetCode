package question1504_count_submatrices_with_all_ones;

import java.util.Stack;

public class Solution2 {

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] leftOnes = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    leftOnes[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    leftOnes[i][j] = leftOnes[i][j - 1] + 1;
                }
            }
        }
        int result = 0;
        for (int j = 0; j < n; j++) {
            int i = 0;
            Stack<int[]> deque = new Stack<>();
            int sum = 0;
            while (i < m) {
                int height = 1;
                while (!deque.isEmpty() && deque.peek()[0] > leftOnes[i][j]) {
                    sum -= deque.peek()[1] * (deque.peek()[0] - leftOnes[i][j]);
                    height += deque.peek()[1];
                    deque.pop();
                }
                sum += leftOnes[i][j];
                result += sum;
                deque.add(new int[] {leftOnes[i][j], height});
                i++;
            }
        }
        return result;
    }

}