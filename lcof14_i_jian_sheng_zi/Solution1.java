package lcof14_i_jian_sheng_zi;

/**
 * 递归。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.7MB，击败100.00%。
 */
public class Solution1 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        return cuttingRopeHelper(n);
    }

    private int cuttingRopeHelper(int n) {
        if (n <= 4) {
            return n;
        }
        return 3 * cuttingRopeHelper(n - 3);
    }
}