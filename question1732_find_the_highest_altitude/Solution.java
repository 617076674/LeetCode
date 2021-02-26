package question1732_find_the_highest_altitude;

public class Solution {

    public int largestAltitude(int[] gain) {
        int height = 0, result = 0;
        for (int gap : gain) {
            height += gap;
            result = Math.max(height, result);
        }
        return result;
    }

}