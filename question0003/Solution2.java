package question0003;

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
        int n = s.length();
        boolean[] appear = new boolean[256];
        int left = 0, right = -1, result = 0; //滑动窗口范围是[left, right]
        while (right + 1 < n) {
            if (!appear[s.charAt(right + 1)]) {
                right++;
                appear[s.charAt(right)] = true;
            } else {
                appear[s.charAt(left)] = false;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}