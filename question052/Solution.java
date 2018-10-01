package question052;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82796011
 */
import java.util.HashMap;

public class Solution {

	int result;
	
	public int totalNQueens(int n) {
		boolean[][] visited = new boolean[n][n];
		totalNQueens(new HashMap<>(), 0, n, visited);
		return result;
	}
	
	/*
	 * hashMap-------The queen in row key is in column value
	 * we are going to put the mth queen
	 * n represents the total quantity of the queen
	 */
	private void totalNQueens(HashMap<Integer, Integer> hashMap, int m, int n, boolean[][] visited) {
		if(m == n) {
			result++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!visited[m][i]) {
				hashMap.put(m, i);
				boolean[][] tempVisited = new boolean[n][n];
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						tempVisited[j][k] = visited[j][k];
					}
				}
				for (int j = 0; j < n; j++) {
					tempVisited[j][hashMap.get(m)] = true;
					tempVisited[m][j] = true;
					for (int k = 0; k < n; k++) {
						if((Math.abs(j - m) == Math.abs(k - hashMap.get(m)))) {
							tempVisited[j][k] = true;
						}
					}
				}
				totalNQueens(hashMap, m + 1, n, tempVisited);
				hashMap.remove(m);
			}
		}
	}
}
