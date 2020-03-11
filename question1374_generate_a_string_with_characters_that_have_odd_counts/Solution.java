package question1374_generate_a_string_with_characters_that_have_odd_counts;

/**
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：36.9MB，击败100.00%。
 */
public class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            return "";
        }
        if ((n & 1) == 1) {
            while (sb.length() < n) {
                sb.append('a');
            }
            return sb.toString();
        }
        return "b" + generateTheString(n - 1);
    }
}