package question1180_count_substrings_with_only_one_distinct_letter;

/**
 * 时间复杂度是O(n)，其中n为字符串S的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败80.42%。消耗内存：37.6MB，击败10.00%。
 */
public class Solution {
    public int countLetters(String S) {
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            int j = i;
            while (j + 1 < S.length() && S.charAt(j + 1) == S.charAt(i)) {
                j++;
            }
            int same = j - i + 1;
            result += ((1 + same) * same >> 1);
            i = j;
        }
        return result;
    }
}