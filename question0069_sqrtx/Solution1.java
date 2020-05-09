package question0069_sqrtx;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(x ^ 0.5)。空间复杂度是O(1)。
 *
 * 执行用时：41ms，击败6.93%。消耗内存：34.1MB，击败75.02%。
 */
public class Solution1 {
    public int mySqrt(int x) {
        for (long i = 1; i <= x; i++) {
            if (i * i > x) {
                return (int) (i - 1);
            } else if (i * i == x) {
                return (int) i;
            }
        }
        return 0;
    }
}