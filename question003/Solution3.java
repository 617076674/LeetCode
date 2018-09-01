package question003;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution3 {
	
	public int lengthOfLongestSubstring(String s) {

		int[] freq = new int[256];
		int l = 0, r = -1; //滑动窗口为s[l...r]
		int res = 0;
		// 在这里, 循环中止的条件可以是 r + 1 < s.length(), 想想看为什么?
		//因为找的是不包含重复字符的最长子串，当right移动到最右边之后，left向再右缩进只会减短子串的长度！
		while( r + 1 < s.length() ){

			if( r + 1 < s.length() && freq[s.charAt(r+1)] == 0 )
				freq[s.charAt(++r)] ++;
			else    //freq[s[r+1]] == 1
				freq[s.charAt(l++)] --;

			res = Math.max(res, r-l+1);
		}
		return res;
	}
}
