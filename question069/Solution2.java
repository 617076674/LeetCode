package question069;

public class Solution2 {

	public int mySqrt(int x) {
		int left = 1;
		int right = x;
		int mid = left + (right - left) / 2;
		while(left < right) {
			if((long)mid * (long)mid == x) {
				break;
			}else if((long)mid * (long)mid > x) {
				right = mid - 1;
				mid = left + (right - left) / 2;
			}else if((long)mid * (long)mid < x) {
				left = mid + 1;
				mid = left + (right - left) / 2;
			}
		}
        return (long)mid * (long)mid > x ? mid - 1 : mid;
	}
}
