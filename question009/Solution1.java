package question009;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/81937355
 */
public class Solution1 {
	
	public boolean isPalindrome(int x) {
        String string = Integer.toString(x);
        int n = string.length();
        for (int i = 0; i <= n / 2; i++) {
			if(string.charAt(i) != string.charAt(n - i - 1)) {
				return false;
			}
		}
        return true;
    }
}
