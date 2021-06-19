package question0231_power_of_two;

public class Solution1 {

    public boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return n == 1;
    }

}