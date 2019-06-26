package question069;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82861877
 */
public class Solution2 {

    public int mySqrt(int x) {
        int left = 0, right = x / 2 + 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return right;
    }
}
