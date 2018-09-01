package question003;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution4 {
	
	public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int left = 0, right = -1; 
        int res = 0;
        if(s.length() == 1) {
        	return res + 1;
        }
        while(right + 1 < s.length()) {
        	while(right + 1 < s.length() && freq[s.charAt(right + 1)] == 0) {
        		freq[s.charAt(++right)]++;
        	}
        	res = Math.max(res, right - left + 1);
        	if(right + 1 < s.length()) {
        		freq[s.charAt(++right)]++;
        		while(left <= right && freq[s.charAt(right)] == 2) {
        			freq[s.charAt(left++)]--;
        		}
        	}
        }
        return res;
	}
}
