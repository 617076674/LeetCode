package question5205_unique_number_of_occurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为arr数组的长度。
 *
 * 执行用时：3ms，击败73.98%。消耗内存：36MB，击败100.00%。
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}
