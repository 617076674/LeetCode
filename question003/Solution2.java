package question003;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution2 {
	
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[256];
        int left = 0;
        int right = -1;			//[left, right] is our overflow window
        int result = 0;
        while(left < n) {
        	if(right + 1 < n && freq[s.charAt(right + 1)] == 0) {
        		right++;
        		freq[s.charAt(right)] = 1;
        	}else {
        		freq[s.charAt(left)] = 0;
        		left++;
        	}
        	result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
