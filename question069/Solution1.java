package question069;

public class Solution1 {
	
    public int mySqrt(int x) {
        for (long i = 1; i <= x; i++) {
			if(i * i > x) {
				return (int)(i - 1);
			}else if(i * i == x) {
				return (int)i;
			}
		}
        return 0;
    }
}
