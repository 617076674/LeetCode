package question1893_check_if_all_the_integers_in_a_range_are_covered;

public class Solution {

    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (!isCovered(ranges, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCovered(int[][] ranges, int num) {
        for (int[] range : ranges) {
            if (num >= range[0] && num <= range[1]) {
                return true;
            }
        }
        return false;
    }

}