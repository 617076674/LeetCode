package question003;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution5 {

	public int lengthOfLongestSubstring(String s) {
		int left = 0;
		int right = 0;		
		int result = 0;
		while(right < s.length()) {
			int index = isDuplicateChar(s, left, right);
			if(index != -1) {
				left = index + 1;
			}
			result = Math.max(result, right - left + 1);
			right++;
		}
		return result;
	}
	
	private int isDuplicateChar(String s, int left, int right) {
		for(int i = left ; i < right ; i ++)
            if(s.charAt(i) == s.charAt(right))
                return i;
        return -1;
	}
}
