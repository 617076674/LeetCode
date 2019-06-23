package question0010;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82010888
 *
 * 递归实现。
 *
 * 执行用时：312ms，击败8.95%。消耗内存：111.6MB，击败5.03%。
 */
public class Solution1 {
	public boolean isMatch(String s, String p) {
		int ns = s.length(), np = p.length();
		if(ns == 0 && np == 0) {
			return true;
		}
		if(ns != 0 && np == 0) {
			return false;
		}
		if(ns == 0) {
			if((np & 1) == 1) {
				return false;
			}
			int i = 1;
	        while (i < p.length() && p.charAt(i) == '*') {
	        	i += 2;
	        }
			return i == p.length() + 1;
		}
		if(s.charAt(ns - 1) == p.charAt(np - 1) || p.charAt(np - 1) == '.') {
			return isMatch(s.substring(0, ns - 1), p.substring(0, np - 1));
		}
		if(p.charAt(np - 1) == '*') {
			if(s.charAt(ns - 1) != p.charAt(np - 2) && p.charAt(np - 2) != '.') {
				return isMatch(s, p.substring(0, np - 2));
			}
			return isMatch(s.substring(0, ns - 1), p) || isMatch(s, p.substring(0, np - 1))
					|| isMatch(s, p.substring(0, np - 2));
		}
		return false;
	}
}
