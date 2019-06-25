package question0326;

/**
 * @author qianyihui
 * @date 2019-06-25
 *
 * 纯数学知识：1162261467是int型范围内的3的幂的最大值。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：85ms，击败69.11%。消耗内存：39.8MB，击败15.06%。
 */
public class Solution3 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
