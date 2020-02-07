package question0058_length_of_last_word;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 *
 * 注意对单词前后空格的处理。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：35.9MB，击败77.31%。
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int n;
        if (null == s || (n = s.length()) == 0) {
            return 0;
        }
        int i = n - 1;
        while (s.charAt(i) == ' ') {
            if (--i < 0) {
                return 0;
            }
        }
        int start = i;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return start - i;
    }
}