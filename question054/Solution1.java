package question054;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int m = matrix.length;
		if(m == 0) {
			return list;
		}
		int n = matrix[0].length;
		if(n == 0) {
			return list;
		}
		boolean[][] visited = new boolean[m][n];
		int turn = Math.min(m, n) % 2 == 0 ? Math.min(m, n) / 2 : Math.min(m, n) / 2 + 1;
		for (int k = 0; k < turn; k++) {	
			for (int i = k; i < n; i++) {
				if(!visited[k][i]) {
					list.add(matrix[k][i]);
					visited[k][i] = true;
				}
			}
			for (int i = k; i < m; i++) {
				if(!visited[i][n - 1 - k]) {
					list.add(matrix[i][n - 1 - k]);
					visited[i][n - 1 - k] = true;
				}
			}
			for (int i = n - 1; i >= 0; i--) {
				if(!visited[m - 1 - k][i]) {
					list.add(matrix[m - 1 - k][i]);
					visited[m - 1 - k][i] = true;
				}
			}
			for (int i = m - 1; i >= 0; i--) {
				if(!visited[i][k]) {
					list.add(matrix[i][k]);
					visited[i][k] = true;
				}
			}
		}
		return list;
	}
}
