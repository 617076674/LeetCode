package question0389;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为字符串s的长度，n2为字符串t的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败40.85%。消耗内存：36.2MB，击败70.70%。
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map[c - 'a']--;
            if (map[c - 'a'] < 0) {
                return c;
            }
        }
        return 'a';
    }
}
