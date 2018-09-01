package question009;

import java.util.ArrayList;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/81937355
 */
public class Solution2 {
	
	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		if(x == 0) {
			return true;
		}
        ArrayList<Character> arrayList = new ArrayList<>();
        while(x > 0) {
        	arrayList.add((char)(x % 10));
        	x /= 10;
        }
        for (int i = 0; i <= arrayList.size() / 2; i++) {
			if(arrayList.get(i) != arrayList.get(arrayList.size() - 1 - i)) {
				return false;
			}
		}
        return true;
    }
}
