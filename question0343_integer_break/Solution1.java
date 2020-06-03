package question0343_integer_break;

/**
 * 递归。
 *
 * 时间复杂度是O(2 ^ n)。空间复杂度是 O(n)。
 *
 * 执行用时：8ms，击败20.15%。消耗内存：36.2MB，击败7.69%。
 */
public class Solution1 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        return integerBreakHelper(n);
    }

    private int integerBreakHelper(int n) {
        if (n <= 4) {
            return n;
        }
        return Math.max(2 * integerBreakHelper(n - 2), 3 * integerBreakHelper(n - 3));
    }
}