package question1390_four_divisors;

/**
 * 暴力破解法。
 *
 * 执行用时：112ms，击败32.31%。消耗内存：41.7MB，击败100.00%。
 */
public class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int tmp = calculateFactors(num);
            if (tmp != -1) {
                result += tmp;
            }
        }
        return result;
    }

    private int calculateFactors(int num) {
        int sum = 0, count = 0;
        for (int i = 1; i <= ((int) Math.sqrt(num)); i++) {
            if (num % i == 0) {
                sum += i + num / i;
                if (i == num / i) {
                    return -1;
                } else {
                    count += 2;
                }
            }
        }
        return count == 4 ? sum : -1;
    }
}