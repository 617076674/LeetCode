package question1221_split_a_string_in_balanced_strings;

/**
 * 贪心算法。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：34MB，击败100.00%。
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int countR = 0, countL = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                countR++;
            } else if (s.charAt(i) == 'L') {
                countL++;
            }
            if (countR == countL) {
                countR = 0;
                countL = 0;
                result++;
            }
        }
        return result;
    }
}
