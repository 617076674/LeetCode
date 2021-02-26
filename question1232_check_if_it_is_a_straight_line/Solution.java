package question1232_check_if_it_is_a_straight_line;

/**
 * 时间复杂度是O(n)，其中n为coordinates数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.4MB，击败96.49%。
 */
public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][0] - coordinates[0][0], dy = coordinates[1][1] - coordinates[0][1], gcd = gcd(dx, dy);
        dx /= gcd;
        dy /= gcd;
        for (int i = 2; i < coordinates.length; i++) {
            int tmpDx = coordinates[i][0] - coordinates[i - 1][0], tmpDy = coordinates[i][1] - coordinates[i - 1][1],
                    tmpGcd = gcd(tmpDx, tmpDy);
            tmpDx /= tmpGcd;
            tmpDy /= tmpGcd;
            if (tmpDx != dx || tmpDy != dy) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}