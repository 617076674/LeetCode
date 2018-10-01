package question062;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82834260
 */
public class Solution {
	
	public int uniquePaths(int m, int n) {
		int[][] map = new int[m][n];
		for (int i = 0; i < n; i++) {
			map[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			map[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[m - 1][n - 1];
	}
}
