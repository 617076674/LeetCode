package question0014_longest_common_prefix;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 二分查找法。
 *
 * 时间复杂度是O(n * log(m))，其中n为strs数组的大小，m为strs数组中最短字符串的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.91%。消耗内存：35.5MB，击败90.17%。
 */
public class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        int minLen = strs[0].length();  //strs数组中最短字符串的长度
        for (int i = 1; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        int left = 0, right = minLen - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (isCommonPrefix(strs, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return strs[0].substring(0, left);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String tmp = strs[0].substring(0, len + 1);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(tmp)) {
                return false;
            }
        }
        return true;
    }
}