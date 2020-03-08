package question0734_sentence_similarity;

import java.util.*;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n1 + n)，其中n1是words1数组的长度。n是pairs的长度。空间复杂度是O(n)。
 *
 * 执行用时：2ms，击败100.00%。消耗内存：38.6MB，击败10.00%。
 */
public class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        int n1 = words1.length, n2 = words2.length;
        if (n1 != n2) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            if (!map.containsKey(pair.get(0))) {
                map.put(pair.get(0), new HashSet<>());
            }
            map.get(pair.get(0)).add(pair.get(1));
        }
        for (int i = 0; i < n1; i++) {
            if (!words1[i].equals(words2[i]) && !(map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i]))
                    && !(map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i]))) {
                return false;
            }
        }
        return true;
    }
}