package question0748_shortest_completing_word;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n为words数组中的字符串的总字符数。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败97.40%。消耗内存：38MB，击败100.00%。
 */
public class Solution {
    private int[] map = new int[26];

    public String shortestCompletingWord(String licensePlate, String[] words) {
        fillMap(map, licensePlate);
        String result = null;
        for (String word : words) {
            if (result == null) {
                if (isCompletingWord(word)) {
                    result = word;
                }
            } else {
                if (result.length() > word.length() && isCompletingWord(word)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private void fillMap(int[] map, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                map[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                map[c - 'a']++;
            }
        }
    }

    private boolean isCompletingWord(String word) {
        int[] wordMap = new int[26];
        fillMap(wordMap, word);
        for (int i = 0; i < 26; i++) {
            if (wordMap[i] < map[i]) {
                return false;
            }
        }
        return true;
    }
}
