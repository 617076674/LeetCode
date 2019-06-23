package question0009;

/**
 * 执行用时：61ms，击败33.72%。消耗内存：37.6MB，击败86.64%。
 */
public class Solution3 {
	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		if(x <= 9) {
			return true;
		}
		int num = 0, temp = x;
        while(temp > 0) {
        	temp /= 10;
        	num++;
        }
        while(num > 1) {
        	int left = x / (int)(Math.pow(10, num - 1));
        	int right = x % 10;
        	if(left != right) {
        		return false;
        	}
        	x = (x - right - left * (int)(Math.pow(10, num - 1))) / 10;
        	num -= 2;
        }
        return true;
    }
}
