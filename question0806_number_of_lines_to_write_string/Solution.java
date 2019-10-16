package question0806_number_of_lines_to_write_string;

/**
 * 时间复杂度是O(n)，其中n为字符串S的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败91.88%。消耗内存：34.8MB，击败81.43%。
 */
public class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int lines = 0, count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (count + widths[c - 'a'] > 100) {
                lines++;
                count = widths[c - 'a'];
            } else {
                count += widths[c - 'a'];
            }
        }
        if (count > 0) {
            lines++;
        }
        return new int[] {lines, count};
    }
}
