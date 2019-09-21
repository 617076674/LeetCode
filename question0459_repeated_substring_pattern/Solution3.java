package question0459_repeated_substring_pattern;

/**
 * 正则表达式。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：80ms，击败51.61%。消耗内存：38MB，击败93.60%。
 */
public class Solution3 {
    public boolean repeatedSubstringPattern(String s) {
        return s.matches("(\\w+)\\1+");
    }
}
