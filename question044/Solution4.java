package question044;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82732623
 */
public class Solution4 {

	//dynamic programming realization2
	public boolean isMatch(String s, String p) {
		int ns = s.length();
        int np = p.length();
		boolean[][] matched = new boolean[ns + 1][np + 1];
		matched[0][0] = true;
		for (int i = 1; i < np + 1; i++) {
			matched[0][i] = true;
			for (int j = 0; j <= i - 1; j++) {
				if(p.charAt(j) != '*') {
					matched[0][i] = false;
				}
			}
		}
		for (int i = 1; i < matched.length; i++) {
			for (int j = 1; j < matched[0].length; j++) {
				if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
					matched[i][j] = matched[i - 1][j - 1];
				}else if(p.charAt(j - 1) == '*') {
					matched[i][j] = matched[i - 1][j] || matched[i][j - 1];
				}
			}
		}
		return matched[ns][np];
	}
}
