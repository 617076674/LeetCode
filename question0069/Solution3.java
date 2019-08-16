package question0069;

/**
 * 牛顿迭代法。
 *
 * 执行用时：3ms，击败95.13%。消耗内存：34MB，击败75.02%。
 */
public class Solution3 {
    public int mySqrt(int x) {
        double pre = 0, cur = 1;
        while (Math.abs(pre - cur) >= 0.000001) {
            pre = cur;
            cur = (x + cur * cur) / (2 * cur);
        }
        return (int) pre;
    }
}