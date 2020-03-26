package question0953_verifying_an_alien_dictionary;

/**
 * 时间复杂度是O(n)，其中n为words中的字符数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38.4MB，击败6.10%。
 */
public class Solution {
    private int[] map = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (map[c1 - 'a'] < map[c2 - 'a']) {
                return -1;
            } else if (map[c1 - 'a'] > map[c2 - 'a']) {
                return 1;
            }
        }
        return s1.length() - s2.length();
    }
}