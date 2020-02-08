package question1317_convert_integer_to_the_sum_of_two_no_zero_integers;

/**
 * 执行用时：1ms，击败100.00%。消耗内存：34.4MB，击败100.00%。
 */
public class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (isNoZeroIntegers(i) && isNoZeroIntegers(n - i)) {
                return new int[] {i, n - i};
            }
        }
        return null;
    }

    private boolean isNoZeroIntegers(int n) {
        while (n > 1) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}