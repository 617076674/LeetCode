package question1189_maximum_number_of_balloons;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n为text的长度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败38.03%。消耗内存：35.8MB，击败100.00%。
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        if (!map.containsKey('b') || !map.containsKey('a') || !map.containsKey('l') || !map.containsKey('o') || !map.containsKey('n')) {
            return 0;
        }
        int min = map.get('b');
        min = Math.min(min, map.get('a'));
        min = Math.min(min, map.get('l') >> 1);
        min = Math.min(min, map.get('o') >> 1);
        min = Math.min(min, map.get('n'));
        return min;
    }
}
