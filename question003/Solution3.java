package question003;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution3 {
	
	public int lengthOfLongestSubstring(String s) {

		int[] freq = new int[256];
		int l = 0, r = -1; 
		int res = 0;
		while( r + 1 < s.length() ){

			if( r + 1 < s.length() && freq[s.charAt(r+1)] == 0 )
				freq[s.charAt(++r)] ++;
			else    
				freq[s.charAt(l++)] --;

			res = Math.max(res, r-l+1);
		}
		return res;
	}
}
