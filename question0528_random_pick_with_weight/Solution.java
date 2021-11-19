package question0528_random_pick_with_weight;

import java.util.Random;

public class Solution {

    private int[] preSum;

    private int sum = 0;

    private static Random rand = new Random();

    public Solution(int[] w) {
        preSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            preSum[i] = sum;
        }
    }

    public int pickIndex() {
        int num = rand.nextInt(sum), left = 0, right = preSum.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (num == preSum[mid]) {
                left = mid + 1;
            } else if (num > preSum[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}