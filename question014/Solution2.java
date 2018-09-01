package question014;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82141995
 */
public class Solution2 {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		return longestCommonPrefix(strs, 0, strs.length - 1);
	}
	
	private String longestCommonPrefix(String[] strs, int left, int right) {
		if(left == right) {
			return strs[left];
		}
		int mid = left + (right - left) / 2;
		String leftResult = longestCommonPrefix(strs, left, mid);
		String rightResult = longestCommonPrefix(strs, mid + 1, right);
		int i = 0;
		for(; i < leftResult.length(); i++) {
			if(rightResult.length() <= i || rightResult.charAt(i) != leftResult.charAt(i)) {
				break;
			}
		}
		return leftResult.substring(0, i);
	}
}
