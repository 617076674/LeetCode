package question0242_valid_anagram;

/**
 * 哈希表（数组）。
 *
 * 时间复杂度是O(n)，其中n是字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败97.78%。消耗内存：37.2MB，击败95.90。
 */
public class Solution1 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
