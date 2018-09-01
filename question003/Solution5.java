package question003;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution5 {

	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0;		//滑动窗口为[left, right]
		int res = 0;
		while(right < s.length()) {
			int index = isDuplicateChar(s, left, right);
			//如果s[right]之前出现过
			//left可以直接跳到s[right]之前出现的位置+1的地方
			if(index != -1) {
				left = index + 1;
			}
			res = Math.max(res, right - left + 1);
			right++;
		}
		return res;
	}
	
	//查看s[left, right - 1]之间是否存在s[right]，若存在，返回相应的索引，否则返回-1
	private int isDuplicateChar(String s, int left, int right) {
		for(int i = left ; i < right ; i ++)
            if(s.charAt(i) == s.charAt(right))
                return i;
        return -1;
	}
}
