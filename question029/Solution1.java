package question029;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82413883
 */
public class Solution1 {
	
	public int divide(int dividend, int divisor) {
		if(dividend == 0) {
			return 0;
		}
        //set a flag to record the result is positive or negative
		Boolean flag = true;
		if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			flag = false;
		}
		long tempDividend = (long)dividend;
		long tempDivisor = (long)divisor; 
		if(tempDividend < 0) {
			tempDividend = -tempDividend;
		}
		if(tempDivisor < 0) {
			tempDivisor = -tempDivisor;
		}
		long result = 0;
		while(tempDividend >= tempDivisor) {
			tempDividend -= tempDivisor;
			result++;
		}
		if(flag) {
			if(result > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}else {
				return (int)result;
			}
		}else {
			if(-result < Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			}else {
				return (int)(-result);
			}
		}
    }
}
