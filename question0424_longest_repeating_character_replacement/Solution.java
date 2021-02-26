package question0424_longest_repeating_character_replacement;

/**
 * 滑动窗口法。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：14ms，击败60.80%。消耗内存：39.5MB，击败34.09%。
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        int n;
        if (null == s || (n = s.length()) == 0) {
            return 0;
        }
        //max记录滑动窗口[left, right]中出现次数最多的字符出现的次数
        int left = 0, right = -1, max = Integer.MIN_VALUE, result = 0;
        int[] appears = new int[26];
        while (right + 1 < n) {
            right++;
            max = Math.max(max, ++appears[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                appears[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}