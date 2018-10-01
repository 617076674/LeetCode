package question050;

public class Solution {

	public double myPow(double x, int n) {
        double result = 1;
        if(n == 0) {
        	return result;
        }else if(n > 0) {
        	double temp = myPow(x, n / 2);
        	if(n % 2 == 0) {
        		return temp * temp;
        	}else {
        		return temp * temp * x;
        	}
        }else {
        	double temp = myPow(x, n / 2);
        	if(n % 2 == 0) {
        		return temp * temp;
        	}else {
        		return temp * temp / x;
        	}
        }
    }
}
