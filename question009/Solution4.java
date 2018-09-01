package question009;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/81937355
 */
public class Solution4 {
	
	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		if(x <= 9) {
			return true;
		}
		int reverse = 0;
		int temp = x;
		while(temp > 0) {
			reverse = reverse * 10 + temp % 10;
			temp = temp / 10;
		}
		return reverse == x;
	}
}
