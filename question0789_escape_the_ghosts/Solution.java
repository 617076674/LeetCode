package question0789_escape_the_ghosts;

public class Solution {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = new int[]{0, 0};
        for (int[] ghost: ghosts) {
            if (taxi(ghost, target) <= taxi(source, target)) {
                return false;
            }
        }
        return true;
    }

    public int taxi(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

}