package question0242;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-07-07
 *
 * 如果输入字符串包含unicode字符，哈希表（HashMap）。
 *
 * 时间复杂度是O(n)，其中n是字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：57ms，击败14.57%。消耗内存：43.1MB，击败16.50。
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.size() == 0;
    }
}
