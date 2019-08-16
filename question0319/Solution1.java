package question0319;

import java.util.Arrays;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(n)。
 *
 * 在LeetCode中提交会超时。
 */
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