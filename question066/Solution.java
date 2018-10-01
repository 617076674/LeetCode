package question066;

public class Solution {

	public int[] plusOne(int[] digits) {
        int n = digits.length;
        int flag = 1;
        for (int i = n - 1; i >= 0; i--) {
			digits[i] = digits[i] + flag;
			if(digits[i] >= 10) {
				digits[i] -= 10;
			}else {
				flag = 0;
			}
		}
        if(flag == 1) {
        	int[] result = new int[n + 1];
        	result[0] = 1;
        	return result;
        }else {
        	return digits;
		}
    }
}
