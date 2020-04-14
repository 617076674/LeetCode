package question1411_number_of_ways_to_paint_n_x_3_grid;

public class Solution {
    public int numOfWays(int n) {
        long type3 = 6, type2 = 6;
        for (int i = 1; i < n; i++) {
            long tmp3 = (2 * type3 + 2 * type2) % 1000000007, tmp2 = (2 * type3 + 3 * type2) % 1000000007;
            type3 = tmp3;
            type2 = tmp2;
        }
        return (int) ((type3 + type2) % 1000000007);
    }
}