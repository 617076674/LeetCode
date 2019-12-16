package question0030_substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 *
 * 滑动窗口+哈希表。
 *
 * 时间复杂度是O(m * len)，其中m为字符串s的长度，len为words数组中的单词长度。空间复杂度是O(n)。
 *
 * 执行用时：10ms，击败99.81%。消耗内存：38.7MB，击败97.44%。
 */
public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int n;
        if (null == words || (n =words.length) == 0) {
            return result;
        }
        int m = s.length(), len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            Map<String, Integer> window = new HashMap<>();
            int left = i, right = i;
            while (right < m - len + 1 && left < m - len * n + 1) {
                String tmpRight = s.substring(right, right + len);
                if (!map.containsKey(tmpRight)) {
                    right += len;
                    left = right;
                    window.clear();
                    continue;
                }
                window.put(tmpRight, window.getOrDefault(tmpRight, 0) + 1);
                right += len;
                while (window.get(tmpRight) > map.get(tmpRight)) {
                    String tmpLeft = s.substring(left, left + len);
                    window.put(tmpLeft, window.get(tmpLeft) - 1);
                    if (window.get(tmpLeft) == 0) {
                        window.remove(tmpLeft);
                    }
                    left += len;
                }
                if (right - left == n * len) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}