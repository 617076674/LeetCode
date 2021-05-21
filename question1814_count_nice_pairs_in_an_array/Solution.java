package question1814_count_nice_pairs_in_an_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            int origin = num, reverse = 0;
            while (num > 0) {
                reverse = reverse * 10 + num % 10;
                num /= 10;
            }
            int gap = origin - reverse;
            map.put(gap, map.getOrDefault(gap, 0L) + 1);
        }
        long result = 0;
        for (long value : map.values()) {
            result += value * (value - 1) / 2;
            result %= MOD;
        }
        return (int) result;
    }

}