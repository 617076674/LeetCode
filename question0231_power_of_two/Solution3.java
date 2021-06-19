package question0231_power_of_two;

public class Solution3 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

}