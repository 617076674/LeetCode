package question0762_prime_number_of_set_bits_in_binary_representation;

/**
 * 位运算。
 *
 * 时间复杂度是O(R - L)。空间复杂度是O(1)。
 *
 * 执行用时：16ms，击败59.82%。消耗内存：33.3MB，击败72.06%
 */
public class Solution {
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; i++) {
            if (hasPrimeSetBits(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean hasPrimeSetBits(int num) {
        int countOne = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                countOne++;
            }
            num >>= 1;
        }
        return isPrime(countOne);
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
