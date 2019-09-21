package question0441_arranging_coins;

/**
 * 二分查找法。
 *
 * n的范围            行数            备注
 * [0, 1)             0            0 = 0 * 1 / 2
 * [1, 3)             1            1 = 1 * 2 / 2
 * [3, 6)             2            3 = 2 * 3 / 2
 * [6, 10)            3            6 = 3 * 4 / 2
 * [10, 15)           4            10 = 4 * 5 / 2
 *   ……              ……                ……
 *
 * 对于n，我们需要在[0, n]范围内寻找到一个数m，使得n在[m * (m + 1) / 2, (m + 1) * (m + 2) / 2]之间，我们才能判断层数。
 *
 * 寻找m的过程，可以使用二分查找法。
 *
 * 时间复杂度是O(logn)。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败100.00%。消耗内存：33.9MB，击败75.12%。
 */
public class Solution2 {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            long sum1 = (mid * (mid + 1)) >> 1, sum2 = ((mid + 1) * (mid + 2)) >> 1;
            if (n == sum1) {
                return (int) mid;
            }
            if (n == sum2) {
                return (int) mid + 1;
            }
            if (n < sum1) {
                right = mid - 1;
            } else if (n < sum2) {
                return (int) mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }
}
