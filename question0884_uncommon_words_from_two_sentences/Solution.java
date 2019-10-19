package question0884_uncommon_words_from_two_sentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串A和B中的单词总数。
 *
 * 执行用时：5ms，击败78.15%。消耗内存：36.2MB，击败89.24%。
 */
public class Solution {
    private List<String> list = new ArrayList<>();

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map1 = getMap(A), map2 = getMap(B);
        selectUncommonWords(map1, map2);
        selectUncommonWords(map2, map1);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void selectUncommonWords(Map<String, Integer> map1, Map<String, Integer> map2) {
        for (String s : map1.keySet()) {
            if (map1.get(s) == 1 && !map2.containsKey(s)) {
                list.add(s);
            }
        }
    }

    private Map<String, Integer> getMap(String s) {
        String[] strings = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String tmp : strings) {
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        return map;
    }
}
