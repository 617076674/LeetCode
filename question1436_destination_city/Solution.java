package question1436_destination_city;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 paths 中的元素个数。
 *
 * 执行用时：3ms，击败62.70%。消耗内存：39.7MB，击败100.00%。
 */
public class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        for (List<String> path : paths) {
            beginSet.add(path.get(0));
            endSet.add(path.get(1));
        }
        for (String end : endSet) {
            if (!beginSet.contains(end)) {
                return end;
            }
        }
        return null;
    }
}