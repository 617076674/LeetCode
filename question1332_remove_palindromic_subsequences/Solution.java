package question1332_remove_palindromic_subsequences;

/**
 * （1）如果s为null或者s的长度为0，直接返回0。
 * （2）如果s是一个回文串，直接返回1。
 * （3）否则，直接返回2。因为题目可以删除的是回文子序列，而字符串s中的字符只有a和b，那么最多删除2次（全a和全b）。
 *
 * 时间复杂度是O(n)，其中n是字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.3MB，击败100.00%。
 */
public class Solution {
    public int removePalindromeSub(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < (s.length() >> 1); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}