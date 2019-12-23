package question1079_letter_tile_possibilities;

import java.util.HashSet;
import java.util.Set;

/**
 * 计数+回溯
 *
 * 时间复杂度是O(26 ^ n)，其中n是字符串tiles的长度。空间复杂度是O(n)。
 *
 * 执行用时：21ms，击败49.34%。消耗内存：38.8MB，击败100.00%。
 */
public class Solution {
    private Set<String> set = new HashSet<>();

    private int[] map = new int[26];

    public int numTilePossibilities(String tiles) {
        for (int i = 0; i < tiles.length(); i++) {
            map[tiles.charAt(i) - 'A']++;
        }
        numTilePossibilities(new StringBuilder(), tiles);
        return set.size();
    }

    private void numTilePossibilities(StringBuilder sb, String tiles) {
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                map[i]--;
                sb.append((char) ('A' + i));
                set.add(sb.toString());
                numTilePossibilities(sb, tiles);
                sb.deleteCharAt(sb.length() - 1);
                map[i]++;
            }
        }
    }
}