package question0949_largest_time_for_given_digits;

/**
 * 暴力破解法。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：10ms，击败54.52%。消耗内存：37.8MB，击败10.53%。
 */
public class Solution {
    public String largestTimeFromDigits(int[] A) {
        int result = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != i) {
                    for (int k = 0; k < 4; k++) {
                        if (k != i && k != j) {
                            int l = 6 - i - j - k, hours = 10 * A[i] + A[j], minutes = 10 * A[k] + A[l];
                            if (hours < 24 && minutes < 60) {
                                result = Math.max(result, hours * 60 + minutes);
                            }
                        }
                    }
                }
            }
        }
        return result >= 0 ? String.format("%02d:%02d", result / 60, result % 60) : "";
    }
}