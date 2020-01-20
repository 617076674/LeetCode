package question1281_subtract_the_product_and_sum_of_digits_of_an_integer;

/**
 * 时间复杂度是O(logn)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.3MB，击败100.00%。
 */
public class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n > 0) {
            int num = n % 10;
            n /= 10;
            product *= num;
            sum += num;
        }
        return product - sum;
    }
}