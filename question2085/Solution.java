package question2085;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = words2Map(words1), map2 = words2Map(words2);
        int result = 0;
        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            if (entry1.getValue() == 1 && map2.getOrDefault(entry1.getKey(), 0) == 1) {
                result++;
            }
        }
        return result;
    }

    private static Map<String, Integer> words2Map(String[] words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            result.put(word, result.getOrDefault(word, 0) + 1);
        }
        return result;
    }

}