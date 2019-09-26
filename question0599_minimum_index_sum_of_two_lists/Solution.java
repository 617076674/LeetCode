package question0599_minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是O(n1 + n2)，其中n1为list1的长度，n2为list2的长度。
 *
 * 执行用时：18ms，击败88.69%。消耗内存：39MB，击败97.85%。
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        List<String> list = new ArrayList<>();
        int sum = Integer.MAX_VALUE;
        for (String string : map1.keySet()) {
            if (map2.containsKey(string)) {
                int index1 = map1.get(string), index2 = map2.get(string);
                if (index1 + index2 < sum) {
                    list.clear();
                    list.add(string);
                    sum = index1 + index2;
                } else if (index1 + index2 == sum) {
                    list.add(string);
                }
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
