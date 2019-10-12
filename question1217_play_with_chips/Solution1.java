package question1217_play_with_chips;

import java.util.HashSet;
import java.util.Set;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为chips数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：5ms，击败13.55%。消耗内存：34.8MB，击败100.00%。
 */
public class Solution1 {
    public int minCostToMoveChips(int[] chips) {
        Set<Integer> set = new HashSet<>();
        for (int chip : chips) {
            set.add(chip);
        }
        int result = Integer.MAX_VALUE;
        for (int position : set) {
            int sum = 0;
            for (int chip : chips) {
                int tmp = Math.abs(chip - position);
                if ((tmp & 1) != 0) {
                    sum += 1;
                }
            }
            result = Math.min(result, sum);
        }
        return result;
    }
}
