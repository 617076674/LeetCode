package question0600_non_negative_integers_without_consecutive_ones;

/**
 * 递归实现。
 *
 * 时间复杂度是 O(num)。空间复杂度是 O(1)。
 *
 * 执行用时：2458ms，击败12.20%。消耗内存：36.4MB，击败100.00%。
 */
public class Solution1 {
    private int result = 1;

    public int findIntegers(int num) {
        findIntegers(num, 1);
        return result;
    }

    private void findIntegers(int n, int now) {
        if (now > n) {
            return;
        }
        result++;
        findIntegers(n, now << 1);
        if ((now & 1) == 0) {
            findIntegers(n, 1 + (now << 1));
        }
    }
}