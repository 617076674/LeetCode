package question0397_integer_replacement;

/**
 * 如果n是1，显然结果就是0。
 *
 * 如果n是3，显然结果是2。
 *
 * 如果n是偶数，有integerReplacement(n) = integerReplacement(n / 2) + 1。
 *
 * 如果n是奇数，
 *
 * 如果n的二进制形式的低2位是11，此时应选择加1，这样转换得到的偶数，其低位连续0的个数较多，可以采取除法运算迅速减小为1。
 *
 * 如果n的二进制形式的低2位是01，此时应选择减1，这样转换得到的偶数，其低位连续0的个数较多，可以采取除法运算迅速减小为1。
 *
 * 时间复杂度和空间复杂度均是O(logn)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38.8MB，击败5.69%。
 */
public class Solution2 {
    public int integerReplacement(int n) {
        return integerReplacement((long) n);
    }

    private int integerReplacement(long n) {
        if (n == 1) {
            return 0;
        }
        if (n == 3) {
            return 2;
        }
        if ((n & 1) == 0) {
            return integerReplacement(n >> 1) + 1;
        }
        if ((n & 2) == 2) {
            return integerReplacement(n + 1) + 1;
        }
        return integerReplacement(n - 1) + 1;
    }
}
