package question0598_range_addition_ii;

/**
 * 每个矩形的左上角坐标都是(0,0)，而右下角坐标是每个操作给出的坐标(i,j)。
 *
 * 时间复杂度是O(ops.length)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败97.83%。消耗内存：36.9MB，击败91.60%。
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minR = m, minC = n;
        for (int[] nums : ops) {
            minR = Math.min(minR, nums[0]);
            minC = Math.min(minC, nums[1]);
        }
        return minR * minC;
    }
}
