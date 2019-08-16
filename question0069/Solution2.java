package question0069;

/**
 * 二分法。
 *
 * 时间复杂度是O(logx)。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败88.32%。消耗内存：34.3MB，击败75.02%。
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
