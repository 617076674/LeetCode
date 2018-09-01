package question005;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/81865177
 */
public class Solution1 {
	
	public String longestPalindrome(String s) {
		String result = "";
        for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if(isPalidrome(s.substring(i, j + 1)) && (j + 1 - i) > result.length()) {
					result = s.substring(i, j + 1);
				}
			}
		}
        return result;
    }
	
	private boolean isPalidrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
