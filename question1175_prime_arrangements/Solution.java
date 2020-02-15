package question1175_prime_arrangements;

/**
 * 执行用时：1ms，击败98.10%。消耗内存：39.6MB，击败5.00%。
 */
public class Solution {
    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return (int) ((factorial(count) * factorial(n - count)) % 1000000007);
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = (result * i) % 1000000007;
        }
        return result;
    }
}