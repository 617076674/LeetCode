package question005;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81865177
 */
public class Solution3 {
	
	public String longestPalindrome(String s) {
		if(s.length() < 2) {
			return s;
		}
		if(s.length() == 2) {
			if(s.charAt(0) == s.charAt(1)) {
				return s;
			}else {
				return s.substring(0, 1);
			}
		}
		String result = "";
		for(int i = 1; i < s.length() - 1; i++) {
			String odd = maxOddPalindrome(s, i - 1, i + 1);
			String even1 = maxEvenPalindrome(s, i - 1, i);
			String even2 = maxEvenPalindrome(s, i, i + 1);
			if(odd.length() > even1.length()) {
				if(even2.length() > odd.length() && even2.length() > result.length()) {
					result = even2;
				}else if(odd.length() > result.length()){
					result = odd;
				}
			}else {
				if(even2.length() > even1.length() && even2.length() > result.length()) {
					result = even2;
				}else if(even1.length() > result.length()) {
					result = even1;
				}
			}
		}
		return result;
    }
	
	private String maxOddPalindrome(String s, int k, int j) {
		while(k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)) {
			k--;
			j++;
		}
		return s.substring(k + 1, j);
	}
	
	private String maxEvenPalindrome(String s, int k, int j) {
		while(k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)) {
			k--;
			j++;
		}
		return s.substring(k + 1, j);
	}
}
