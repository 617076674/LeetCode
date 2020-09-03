package question0459_repeated_substring_pattern;

/**
 * 正则表达式。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：527ms，击败5.03%。消耗内存：40.6MB，击败8.29%。
 */
public class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        return s.matches("(\\w+)\\1+");
    }
}