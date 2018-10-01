package question044;

public class Solution3 {
	
	//recursion realization2
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
        	return isMatch(s.substring(0, ns - 1), p.substring(0, np)) || isMatch(s.substring(0, ns), p.substring(0, np - 1));
        }
        return false;
    }
}
