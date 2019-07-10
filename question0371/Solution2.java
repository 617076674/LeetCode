package question0371;

/**
 * @author qianyihui
 * @date 2019-07-10
 *
 * 利用位运算。
 */
public class Solution2 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b, carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
