package question0010;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82010888
 *
 * 动态规划。
 *
 * 时间复杂度是O(ns * np)，其中ns是字符串s的长度，np是字符串p的长度。
 *
 * 执行用时：8ms，击败87.43%。消耗内存：35.8MB，击败89.46%。
 */
public class Solution2 {
	public boolean isMatch(String s, String p) {
		int ns = s.length() + 1, np = p.length() + 1;
		boolean[][] matched = new boolean[ns][np];
		matched[0][0] = true;
		for (int i = 0; i < ns; i++) {
			for (int j = 1; j < np; j++) {
				if(i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
					matched[i][j] = matched[i - 1][j - 1];
				}
				if(p.charAt(j - 1) == '*') {
					if(i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')) {
						matched[i][j] = matched[i][j - 2];
					}else {
						matched[i][j] = matched[i - 1][j] || matched[i][j - 1] || matched[i][j - 2];
					}
				}
			}
		}
		return matched[ns - 1][np - 1];
	}
}
