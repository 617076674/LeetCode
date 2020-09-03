package question1359_count_all_valid_pickup_and_delivery_options;

/**
 * 时间复杂度是 O(n)。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.5MB，击败48.00%。
 */
public class Solution {
    private int mod = 1000000007;

    public int countOrders(int n) {
        if (n == 1) {
            return 1;
        }
        return (int) (1L * n * (n * 2 - 1) * countOrders(n - 1) % mod);
    }
}