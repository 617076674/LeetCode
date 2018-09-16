package question032;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82555851
 */
public class Solution2 {
	
	public int longestValidParentheses(String s) {
		int result = 0;
		int n = s.length();
		int[] lens = new int[n];
		for (int i = 0; i < n; i++) {
			if(s.charAt(i) == ')') {
				if(i >= 1) {
					if(s.charAt(i - 1) == '(') {
						if(i >= 2) {
							lens[i] = lens[i - 2] + 2; 
						}else {
							lens[i] = 2;
						}
					}else {
						if(i - 1 - lens[i - 1] >= 0 && s.charAt(i - 1 - lens[i - 1]) == '(') {
							if(i - 2 - lens[i - 1] >= 0) {
								lens[i] = lens[i - 1] + lens[i - 2 - lens[i - 1]] + 2;
							}else {
								lens[i] = lens[i - 1] + 2;
							}
						}
					}
				}
			}
			result = Math.max(result, lens[i]);
		}
		return result;
	}
}
