package question0029_divide_two_integers;

/**
 * 对Solution1的改进，倍增每次减去的数。
 *
 * 对于思路一而言，其每次减少的数都是divisor，该数一直保持不变。我们可以想象，如果这个divisor绝对值很小，比如是1，
 * 而dividend的绝对值很大，比如是Integer.MAX_VALUE，那么就要进行Integer.MAX_VALUE次减法，这个时间复杂度是难以接受的。
 *
 * 题目中要求不能用乘法和除法，但我们可以对减数进行倍增操作。对于dividend，如果dividend - divisor > 0，
 * 那么我们下一次减去的数不是divisor，而是divisor + divisor，
 * 这样倍增减数的操作可以使我们的时间复杂度到达O(log(dividend / divisor))的级别。而空间复杂度依然保持O(1)的级别。
 *
 * 对于最乐观的情况，假设divisor + divisor * 2 + divisor * 2 ^ 2 + divisor * 2 ^ 3 + ... + divisor * 2 ^ n = dividend。
 * 那么我们总共只进行了n次操作，这个时间复杂度显然就是O(log(dividend / divisor))。
 * 而如果divisor + divisor * 2 + divisor * 2 ^ 2 + divisor * 2 ^ 3 + ... + divisor * 2 ^ n > dividend，
 * 但是divisor + divisor * 2 + divisor * 2 ^ 2 + divisor * 2 ^ 3 + ... + divisor * 2 ^ (n - 1) < dividend，
 * 那么我们就要以dividend - (divisor + divisor * 2 + divisor * 2 ^ 2 + divisor * 2 ^ 3 + ... + divisor * 2 ^ (n - 1))
 * 为被减数进行重复的操作，即从divisor开始减起。直至我们的被减数小于divisor为止。
 *
 * 时间复杂度是O(log(dividend / divisor))。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败92.24%。消耗内存：34.5MB，击败75.76%。
 */
public class Solution2 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;   //flag为false说明结果是负数
        }
        long tmpDividend = dividend, tmpDivisor = divisor, result = 0;
        if (tmpDividend < 0) {
            tmpDividend = -tmpDividend;   //此处不能用Math.abs()函数，因为对于-2147483648而言，转换为正数会越界
        }
        if (tmpDivisor < 0) {
            tmpDivisor = -tmpDivisor; //同上
        }
        while (tmpDividend >= tmpDivisor) {
            long k = 1, tmp = tmpDivisor;
            while (tmpDividend >= tmp) {
                tmpDividend -= tmp;
                result += k;
                k += k;
                tmp += tmp;
            }
        }
        if (flag) {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) result;
        }
        if (-result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (-result);
    }
}