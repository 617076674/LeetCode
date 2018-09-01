package question009;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/81937355
 */
public class Solution3 {
	
	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		if(x <= 9) {
			return true;
		}
		int num = 0;
		int temp = x;
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
