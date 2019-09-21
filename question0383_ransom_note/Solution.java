package question0383_ransom_note;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为ransomNote的长度，n2为magazine的长度。
 *
 * 执行用时：5ms，击败97.24%。消耗内存：37.9MB，击败95.48%。
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map[c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map[c - 'a'] == 0) {
                return false;
            }
            map[c - 'a']--;
        }
        return true;
    }
}
