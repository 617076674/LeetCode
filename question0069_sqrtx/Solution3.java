package question0069_sqrtx;

/**
 * 牛顿迭代法。
 *
 * 时间复杂度是O(logx)。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败95.13%。消耗内存：34MB，击败75.02%。
 */
public class Solution3 {
    public int mySqrt(int x) {
        double pre = 0.0, cur = 1.0;
        while (Math.abs(pre - cur) >= 0.000001) {
            pre = cur;
            cur = (x + cur * cur) / (2 * cur);
        }
        return (int) pre;
    }
}