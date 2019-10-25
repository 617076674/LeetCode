package question0003_longest_substring_without_repeating_characters;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-4chong-jie/
 *
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 3)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：96ms，击败23.81%。消耗内存：35.9MB，击败99.43%。
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n;
        if (null == s || (n = s.length()) == 0) {
            return 0;
        }
        int result = 1;
        boolean flag;
        //当i为n - result时，最长的字符串也仅仅是[n - result, n - 1]，其长度仅为result，不可能比result更大，故没必要继续判断
        for (int i = 0; i < n - result; i++) {
            for (int j = i + 1; j < n; j++) {
                //判断[i, j]内的字符串是否是不包含重复字符的字符串
                flag = true;   //默认[i, j]内的字符串是不包含重复字符的字符串
                for (int k = i; k < j; k++) {
                    //遍历[i, j)内的字符，如果存在和j处字符相等的字符，那么该子串就不满足条件
                    if (s.charAt(k) == s.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result = Math.max(result, j - i + 1);   //如果[i, j]内的字符串不包含重复字符，那么更新result的值
                } else {
                    break;  //[i, j]已经存在重复字符了，继续增大j已经没有意义，考虑下一个起点i
                }
            }
        }
        return result;
    }
}