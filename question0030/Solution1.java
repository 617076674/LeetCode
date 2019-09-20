package question0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 双指针+哈希表。
 *
 * 时间复杂度是O(m * n * len)，其中m为字符串s的长度，n为words数组的长度，len为words数组中的单词长度。空间复杂度是O(n)。
 *
 * 执行用时：150ms，击败66.03%。消耗内存：39.3MB，击败96.31%。
 */
public class Solution1 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int n;
        if (null == words || (n = words.length) == 0) {
            return result;
        }
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i < s.length() - n * len + 1; i++) {
            Map<String, Integer> tmpMap = new HashMap<>(map);
            int j = 0;
            for (; j < len * n; j += len) {
                String subString = s.substring(i + j, i + j + len);
                if (!tmpMap.containsKey(subString)) {
                    break;
                } else {
                    tmpMap.put(subString, tmpMap.get(subString) - 1);
                    if (tmpMap.get(subString) == 0) {
                        tmpMap.remove(subString);
                    }
                }
            }
            if (j == len * n) {
                result.add(i);
            }
        }
        return result;
    }
}
