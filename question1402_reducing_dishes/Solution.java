package question1402_reducing_dishes;

import java.util.Arrays;

public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return maxSatisfaction(satisfaction, satisfaction.length - 1);
    }

    private int maxSatisfaction(int[] satisfaction, int index) {
         return -1;
    }
}