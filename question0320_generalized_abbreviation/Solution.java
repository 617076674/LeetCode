package question0320_generalized_abbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 时间复杂度是O(n!)，其中n为字符串word的长度。空间复杂度是O(n)。
 *
 * 执行用时：22ms，击败35.53%。消耗内存：49.5MB，击败100.00%。
 */
public class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateAbbreviations(String word) {
        generateAbbreviations(word, 0, new StringBuilder());
        return result;
    }

    private void generateAbbreviations(String word, int index, StringBuilder sb) {
        if (index == word.length()) {
            result.add(sb.toString());
            return;
        }
        sb.append(word.charAt(index));
        generateAbbreviations(word, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (sb.length() == 0 || !(sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9')) {
            for (int i = 1; i <= word.length() - index; i++) {
                generateAbbreviations(word, index + i, new StringBuilder(sb).append(i));
            }
        }
    }
}