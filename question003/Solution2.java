package question003;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution2 {
	
	public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] freq = new int[256];
        int left = 0;
        int right = -1;			//设置[left, right]为滑动窗口
        int len = 0;
        while(left < n) {
        	if(right + 1 < n && freq[arr[right + 1] - 'a' + 'a'] == 0) {
        		right++;
        		freq[arr[right] - 'a' + 'a'] = 1;
        	}else {
        		freq[arr[left] - 'a' + 'a'] = 0;
        		left++;
        	}
        	len = Math.max(len, right - left + 1);
        }
        return len;
    }
}
