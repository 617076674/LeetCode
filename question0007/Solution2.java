package question0007;

/**
 * 利用long型变量来进行这整个计算过程。
 *
 * 时间复杂度是O(log(x))。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败90.56%。消耗内存：34.9MB，击败77.66%。
 */
public class Solution2 {
    public int reverse(int x) {
        boolean flag = true;
        if (x < 0) {
            x = -x;
            flag = false;
        }
        if (x == 0) {
            return 0;
        }
        while (x % 10 == 0) {   //后缀0反转后成为前缀0，不考虑
            x /= 10;
        }
        long result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        if (flag) {
            return (int) result;
        }
        return -(int) result;
    }
}