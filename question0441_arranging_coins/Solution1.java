package question0441_arranging_coins;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：20ms，击败33.03%。消耗内存：33.6MB，击败75.35%。
 */
public class Solution1 {
    public int arrangeCoins(int n) {
        int height = 0, i = 1;
        while (n - i >= 0) {
            height++;
            n -= i;
            i++;
        }
        return height;
    }
}
