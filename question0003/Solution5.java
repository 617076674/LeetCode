package question0003;

import java.util.Arrays;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution5 {
	public int lengthOfLongestSubstring(String s) {
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int left = 0, right = -1, result = 0;
        while(right + 1 < s.length()){
            right++;
            if(last[s.charAt(right)] != -1) {
            	left = Math.max(left, last[s.charAt(right)] + 1);
            }
            result = Math.max(result, right - left + 1);
            last[s.charAt(right)] = right;
        }
        return result;
	}
}
