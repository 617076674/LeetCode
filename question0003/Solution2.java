package question0003;

/**
 * 滑动窗口法。
 * <p>
 * 将一个数组当作哈希表。
 * <p>
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 * <p>
 * 执行用时：9ms，击败97.28%。消耗内存：36.5MB，击败97.26%。
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[256];
        int left = 0, right = -1, result = 0; //滑动窗口范围是[left, right]
        while (left < n) {
            if (right + 1 < n && freq[s.charAt(right + 1)] == 0) {
                right++;
                freq[s.charAt(right)] = 1;
            } else {
                freq[s.charAt(left)] = 0;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
