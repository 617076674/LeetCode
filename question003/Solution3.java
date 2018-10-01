package question003;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution3 {
	
	public int lengthOfLongestSubstring(String s) {
		int[] freq = new int[256];
		int left = 0, right = -1; 
		int result = 0;
		while(right + 1 < s.length()){
			if(freq[s.charAt(right + 1)] == 0 ) {
				right++;
				freq[s.charAt(right)] = 1;
			}
			else {
				freq[s.charAt(left)] = 0;
				left++;
			}
			result = Math.max(result, right - left + 1);
		}
		return result;
	}
}
