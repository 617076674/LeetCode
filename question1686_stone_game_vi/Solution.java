package question1686_stone_game_vi;

import java.util.Arrays;

public class Solution {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[] gap = new int[aliceValues.length];
        for (int i = 0; i < aliceValues.length; i++) {
            gap[i] = aliceValues[i] + bobValues[i];
        }
        Integer[] indexes = new Integer[aliceValues.length];
        for (int i = 0; i < aliceValues.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (index1, index2) -> gap[index2] - gap[index1]);
        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < indexes.length; i++) {
            if ((i & 1) == 0) {
                aliceScore += aliceValues[indexes[i]];
            } else {
                bobScore += bobValues[indexes[i]];
            }
        }
        return aliceScore == bobScore ? 0 : (aliceScore > bobScore ? 1 : -1);
    }

}