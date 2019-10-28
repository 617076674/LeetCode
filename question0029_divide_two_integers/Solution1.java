package question0029_divide_two_integers;

/**
 * 将除法改为多次减法运算。
 *
 * 时间复杂度是O(dividend / divisor)。空间复杂度是O(1)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
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
            tmpDividend -= tmpDivisor;
            result++;
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