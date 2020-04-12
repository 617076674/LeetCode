package question1165_single_row_keyboard;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n为字符串word的长度。空间复杂度是O(1)。
 *
 * 执行用时：7ms，击败76.07%。消耗内存：39.5MB，击败5.88%。
 */
public class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[keyboard.charAt(i) - 'a'] = i;
        }
        int result = map[word.charAt(0) - 'a'] - map[keyboard.charAt(0) - 'a'];
        for (int i = 1; i < word.length(); i++) {
            result += Math.abs(map[word.charAt(i) - 'a'] - map[word.charAt(i - 1) - 'a']);
        }
        return result;
    }
}