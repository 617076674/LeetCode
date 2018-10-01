package question048;

public class Solution {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int k = 0; k <= n / 2; k++) {
			for (int i = k; i < n - 1 - k; i++) {
				int temp = matrix[k][i];
				matrix[k][i] = matrix[n - 1 - i][k];
				matrix[n - 1 - i][k] = matrix[n - 1 - k][n - 1 - i];
				matrix[n - 1 - k][n - 1 - i] = matrix[i][n - 1 - k];
				matrix[i][n - 1 - k] = temp;
			}
		}
    }
}
