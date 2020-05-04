package question0003_longest_substring_without_repeating_characters;

/**
 * 滑动窗口法。
 *
 * 将一个数组当作哈希表。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败97.28%。消耗内存：36.5MB，击败97.26%。
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[256];
        int left = 0, right = 0, result = 0; //滑动窗口范围是[left, right)
        while (right < s.length()) {
            char cRight = s.charAt(right);
            right++;
            window[cRight]++;
            while (window[cRight] > 1) {
                char cLeft = s.charAt(left);
                left++;
                window[cLeft]--;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}