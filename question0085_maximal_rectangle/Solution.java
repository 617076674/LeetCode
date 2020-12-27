package question0085_maximal_rectangle;

import java.util.LinkedList;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        for (int i = 0; i < n; i++) {
            heights[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0') {
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            result = Math.max(result, maximalRectangle(heights[i]));
        }
        return result;
    }

    /**
     * LeetCode0084
     */
    private int maximalRectangle(int[] heights) {
        int result = 0;
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = newHeights[heights.length + 1] = -1;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int index = stack.pop();
                result = Math.max(result, newHeights[index] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return result;
    }

}