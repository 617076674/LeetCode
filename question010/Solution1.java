package question010;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/82010888
 */
public class Solution1 {

	public boolean isMatch(String s, String p) {
		int ns = s.length();
		int np = p.length();
		if(ns == 0 && np == 0) {
			return true;
		}
		if(ns != 0 && np == 0) {
			return false;
		}
		if(ns == 0) {
			if(np % 2 == 1) {
				return false;
			}
			int i = 1;
	        while (i < p.length() && p.charAt(i) == '*') {
	        	i += 2;
	        }
	        if(i == p.length() + 1) { 
	        	return true;
	        }else {
	        	return false;
	        }
		}
		if(s.charAt(ns - 1) == p.charAt(np - 1) || p.charAt(np - 1) == '.') {
			return isMatch(s.substring(0, ns - 1), p.substring(0, np - 1));
		}
		if(p.charAt(np - 1) == '*') {
			if(s.charAt(ns - 1) != p.charAt(np - 2) && p.charAt(np - 2) != '.') {
				return isMatch(s.substring(0, ns), p.substring(0, np - 2));
			}else {
				return isMatch(s.substring(0, ns - 1), p) || isMatch(s.substring(0, ns), p.substring(0, np - 1)) || isMatch(s.substring(0, ns), p.substring(0, np - 2));
			}
		}
		return false;
	}
}
