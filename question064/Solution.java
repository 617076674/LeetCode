package question064;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82834757
 */
public class Solution {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		if(m == 0) {
			return 0;
		}
		int n = grid[0].length;
		int[][] map = new int[m][n];
		map[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			map[0][i] = map[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			map[i][0] = map[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = Math.min(map[i - 1][j], map[i][j - 1]) + grid[i][j];
			}
		}
		return map[m - 1][n - 1];
	}
}
