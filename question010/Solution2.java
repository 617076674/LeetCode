package question010;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/82010888
 */
public class Solution2 {

	/*
	 * 状态定义：f(x, y)------字符串s中[0, x - 1]范围内的字符串能否匹配字符串p中[0, y - 1]范围内的字符串
	 * 状态转移：
	 * 			1.如果p(y) == '.', f(x, y) == f(x - 1, y - 1).
	 * 			2.如果p(y) == s(x), f(x, y) == f(x - 1, y - 1).
	 * 			3.如果p(y) == '*'
	 * 				3-1.如果s(x) == p(y - 1) || p(y - 1) == '.', 
	 * 					3-1-1.使用'*'号进行匹配-----f(x - 1, y)
	 * 					3-1-2.只使用'*'号前面的那个字符匹配，不使用'*'匹配-----f(x, y - 1)
	 * 					3-1-3.'*'号前面的那个字符在匹配的过程当中一个都不使用-----f(x, y - 2)
	 * 				f(x, y) = f(x - 1, y) || f(x, y - 1) || f(x, y - 2)
	 * 				3-2.如果s(x) != p(y - 1) && p(y - 1) != '.'
	 * 					*号前面的那个字符在匹配的过程当中一个都不使用。
	 * 				f(x, y) = f(x, y - 2)
	 */
	public boolean isMatch(String s, String p) {
		int ns = s.length() + 1;
		int np = p.length() + 1;
		boolean[][] matched = new boolean[ns][np];
		//当s字符串为空的特殊处理

		//f(0, 0)表示s字符串为空，p字符串为空的情形
		matched[0][0] = true;
		//状态转移过程
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
