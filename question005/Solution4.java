package question005;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81865177
 */
public class Solution4 {

	public String longestPalindrome(String s) {
		if(s.length() < 2) {
			return s;
		}
		int n = s.length();
		int[][] maxLen = new int[n][n];
		for (int i = 0; i < n; i++) {
			maxLen[i][i] = 1;
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				int left = i;
				int right = j;
				while(left <= right) {
					if(s.charAt(left) != s.charAt(right)) {
						break;
					}
					left++;
					right--;
				}
				if(left >= right) {
					maxLen[i][j] = j - i + 1;
				}else {
					maxLen[i][j] = Math.max(maxLen[i + 1][j], maxLen[i][j - 1]);
				}
			}
		}
		if(maxLen[0][n - 1] == 1) {
			return s.substring(0, 1);
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if(maxLen[i][j] == maxLen[0][n - 1]) {
					return s.substring(i, j + 1);
				}
			}
		}
		return "";
	}
}
