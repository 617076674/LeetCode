package question0780_reaching_points;

/**
 * 逆向思维
 */
public class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > 0 && ty > 0) {
            if (sx == tx && sy == ty) {
                return true;
            }
            if (tx > ty) {
                tx -= Math.max((tx - sx) / ty, 1) * ty;
            } else {
                ty -= Math.max((ty - sy) / tx, 1) * tx;
            }
        }
        return false;
    }

}