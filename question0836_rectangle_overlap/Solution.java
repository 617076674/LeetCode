package question0836_rectangle_overlap;

/**
 * 先假设矩形rec1的左边小于等于矩形rec2的左边，再对两个矩形的上下边进行讨论。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.8MB，击败91.67%。
 */
public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] > rec2[0]) {
            return isRectangleOverlap(rec2, rec1);
        }
        if (rec1[2] <= rec2[0]) {
            return false;
        }
        if (rec1[3] <= rec2[1] || rec2[3] <= rec1[1]) {
            return false;
        }
        return true;
    }
}
