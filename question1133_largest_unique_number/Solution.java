package question1133_largest_unique_number;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行用时：6ms，击败39.39%。消耗内存：36.8MB，击败100.00%。
 */
public class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int result = -1;
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                result = Math.max(result, num);
            }
        }
        return result;
    }
}