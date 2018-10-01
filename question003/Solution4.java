package question003;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution4 {
	
	public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int left = 0;
        int right = -1; 
        int result = 0;
        while(right + 1 < s.length()) {
        	while(right + 1 < s.length() && freq[s.charAt(right + 1)] == 0) {
        		right++;
        		freq[s.charAt(right)]++;
        	}
        	result = Math.max(result, right - left + 1);
        	if(right + 1 < s.length()) {
        		right++;
        		freq[s.charAt(right)]++;
        		while(left <= right && freq[s.charAt(right)] == 2) {
        			freq[s.charAt(left)]--;
        			left++;
        		}
        	}
        }
        return result;
	}
}

