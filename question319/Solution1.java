package question319;

import java.util.Arrays;

public class Solution1 {
    public int bulbSwitch(int n) {
        int[] bulbs = new int[n];
        Arrays.fill(bulbs, 1);
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == (j + 1) % i) {
                    bulbs[j] *= -1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (1 == bulbs[i]) {
                result++;
            }
        }
        return result;
    }
}
