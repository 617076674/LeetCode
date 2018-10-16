package question085;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83006351
 */
import java.util.Stack;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        for (int i = 0; i < n; i++) {
            heights[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '0'){
                    heights[i][j] = 0;
                }else{
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

    //LeetCode084
    private int maximalRectangle(int[] heights){
        int n = heights.length;
        int[] newHeights = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newHeights[i] = heights[i];
        }
        newHeights[n] = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n + 1; i++) {
            while(!stack.isEmpty() && newHeights[stack.peek()] >= newHeights[i]){
                int index = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                result = Math.max(result, (i - left - 1) * newHeights[index]);
            }
            stack.push(i);
        }
        return result;
    }
}
