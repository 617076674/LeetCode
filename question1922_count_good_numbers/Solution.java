package question1922_count_good_numbers;

public class Solution {

    private static final int MOD = 1000000007;

    private long quickMul(long x, long y) {
        long result = 1, cur = x;
        while (y > 0) {
            if ((y & 1) == 1) {
                result = result * cur % MOD;
            }
            cur = cur * cur % MOD;
            y >>= 1;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long num1 = 5, num2 = 4;
        long count1 = n / 2, count2 = count1;
        if ((n & 1) == 1) {
            count1++;
        }
        return (int) ((quickMul(num1, count1) * quickMul(num2, count2)) % MOD);
    }

}