package question0003;

/**
 * 滑动窗口法。
 */
public class Solution3 {
	public int lengthOfLongestSubstring(String s) {
		int[] freq = new int[256];
		int left = 0, right = -1, result = 0;
		while(right + 1 < s.length()){
			if(freq[s.charAt(right + 1)] == 0 ) {
				right++;
				freq[s.charAt(right)] = 1;
			} else {
				freq[s.charAt(left)] = 0;
				left++;
			}
			result = Math.max(result, right - left + 1);
		}
		return result;
	}
}
