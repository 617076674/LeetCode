package question1503_last_moment_before_all_ants_fall_out_of_a_plank;

public class Solution {

    public int getLastMoment(int n, int[] left, int[] right) {
        int result = 0;
        for (int ant : left) {
            result = Math.max(result, ant);
        }
        for (int ant : right) {
            result = Math.max(result, n - ant);
        }
        return result;
    }

}