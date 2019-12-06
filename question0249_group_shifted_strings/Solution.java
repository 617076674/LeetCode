package question0249_group_shifted_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n为strings数组中的字符数。空间复杂度是O(m)，其中m是strings数组的长度。
 *
 * 执行用时：5ms，击败39.68%。消耗内存：36.4MB，击败100.00%。
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        List<String> single = new ArrayList<>();
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String s : strings) {
            if (s.length() == 1) {
                single.add(s);
            } else {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < s.length() - 1; i++) {
                    list.add((s.charAt(i + 1) - s.charAt(i) + 26) % 26);
                }
                if (!map.containsKey(list)) {
                    map.put(list, new ArrayList<>());
                }
                map.get(list).add(s);
            }
        }
        if (single.size() > 0) {
            result.add(single);
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}