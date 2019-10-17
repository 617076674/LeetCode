package question0819_most_common_word;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n为paragraph的长度。空间复杂度是O(max(p, q))，其中p为banned数组的长度，q为paragraph中的单词数。
 *
 * 执行用时：33ms，击败47.45%。消耗内存：36.7MB，击败97.33%。
 */
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s);
        }
        String[] strings = paragraph.toLowerCase().split("[^a-zA-Z]");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 0) {
                continue;
            }
            if (!bannedSet.contains(strings[i])) {
                if (map.containsKey(strings[i])) {
                    map.put(strings[i], map.get(strings[i]) + 1);
                } else {
                    map.put(strings[i], 1);
                }
            }
        }
        String result = null;
        int times = Integer.MIN_VALUE;
        for (String s : map.keySet()) {
            if (map.get(s) > times) {
                result = s;
                times = map.get(s);
            }
        }
        return result;
    }
}
