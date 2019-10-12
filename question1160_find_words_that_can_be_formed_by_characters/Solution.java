package question1160_find_words_that_can_be_formed_by_characters;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n)，其中n为words数组中各个单词的字符数之和。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败98.90%。消耗内存：38MB，击败100.00%。
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        int[] standard = countChar(chars);
        for (String s : words) {
            if (canBeFormed(countChar(s), standard)) {
                result += s.length();
            }
        }
        return result;
    }

    private int[] countChar(String s) {
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }
        return result;
    }

    private boolean canBeFormed(int[] nums1, int[] nums2) {
        for (int i = 0; i < 26; i++) {
            if (nums1[i] > nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
