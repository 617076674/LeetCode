package question044;

public class Solution1 {
	
	//recursion realization
	public boolean isMatch(String s, String p) {
        int ns = s.length();
        int np = p.length();
        if(np == 0) {
        	return ns == 0;
        }
        if(ns == 0) {
        	for (int i = 0; i < np; i++) {
				if(p.charAt(i) != '*') {
					return false;
				}
			}
        	return true;
        }
        if(p.charAt(np - 1) == '?' || s.charAt(ns - 1) == p.charAt(np - 1)) {
        	return isMatch(s.substring(0, ns - 1), p.substring(0, np - 1));
        }
        if(p.charAt(np - 1) == '*') {
        	for (int i = 0; i <= ns; i++) {
				if(isMatch(s.substring(0, i), p.substring(0, np - 1))) {
					return true;
				}
			}
        }
        return false;
    }
}
