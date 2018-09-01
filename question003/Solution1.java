package question003;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution1 {
	
	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) {
			return 0;
		}
		int result = 1;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				//判断[i, j]区间内是否有重复元素
				boolean flag = false;
				for(int k = i; k < j; k++) {
					if(s.charAt(k) == s.charAt(j)) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					result = Math.max(result, j - i + 1);
				}else {
					break;
				}
			}
		}
		return result;
	}
}
