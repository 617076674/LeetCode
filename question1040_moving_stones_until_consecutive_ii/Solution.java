package question1040_moving_stones_until_consecutive_ii;

import java.util.Arrays;

public class Solution {

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int[] result = new int[2];
        int n = stones.length;
        result[0] = result[1] = stones[n - 1] - stones[0] + 1 - n -
            Math.min(stones[n - 1] - stones[n - 2] - 1, stones[1] - stones[0] - 1);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                j++;
            }
            int cost = n - (j - i + 1);
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                cost = 2;
            }
            result[0] = Math.min(result[0], cost);
        }
        return result;
    }

}