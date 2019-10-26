package question1037_valid_boomerang;

/**
 * 斜率。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.2MB，击败100.00%。
 */
public class Solution {
    public boolean isBoomerang(int[][] points) {
        int dx1 = points[1][0] - points[0][0], dy1 = points[1][1] - points[0][1];
        int dx2 = points[2][0] - points[1][0], dy2 = points[2][1] - points[1][1];
        return dx1 * dy2 != dx2 * dy1;
    }
}
