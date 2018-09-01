package question007;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81915741
 */
public class Solution1 {
	
	public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        if(x < 0) {
        	x = -x;
        	stringBuilder.append("-");
        }
        while(x > 0) {
        	stringBuilder.append(x % 10);
        	x /= 10;
        }
        try {
        	return Integer.parseInt(stringBuilder.toString()); 
        } catch (Exception e) {
			return 0;
		}
    }
}
