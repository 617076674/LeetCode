package question1085_sum_of_digits_in_the_minimum_number;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：37.5MB，击败9.52%。
 */
public class Solution {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int num : A) {
            min = Math.min(min, num);
        }
        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        if ((sum & 1) == 1) {
            return 0;
        }
        return 1;
    }
}