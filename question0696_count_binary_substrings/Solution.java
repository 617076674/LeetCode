package question0696_count_binary_substrings;

/**
 * 寻找到相邻的不同字符的位置，并计算由这两个字符向左向右同时扩展所能达到满足题意的字符串最长长度。
 *
 * 时间复杂度是O(n ^ 2)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：21ms，击败73.24%。消耗内存：37.7MB，击败88.61%。
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                result += (getLen(s, i, i + 1) >> 1);
            }
        }
        return result;
    }

    /**
     * 是否可以以字符串s中第index个字符为结尾找到一个合法的字符串
     */
    private int getLen(String s, int left, int right) {
        int i = left, j = right;
        while (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(left) && j + 1 < s.length() && s.charAt(j + 1) == s.charAt(right)) {
            i--;
            j++;
        }
        return j - i + 1;
    }
}
