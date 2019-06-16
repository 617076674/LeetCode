package question784;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-06-16
 *
 * 回溯法。
 *
 * 注意：回溯法的每一种入口都需要进行恢复变量操作。
 *
 * 时间复杂度和空间复杂度均是O(2 ^ n)，其中n为S中字母的数量。
 *
 * 执行用时：3ms，击败99.67%。消耗内存：38.3MB，击败95.85%。
 */
public class Solution {

    private List<String> result;

    public List<String> letterCasePermutation(String S) {
        result = new ArrayList<>();
        letterCasePermutation(S, 0, new StringBuilder());
        return result;
    }

    private void letterCasePermutation(String s, int index, StringBuilder stringBuilder) {
        if (index == s.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        char c = s.charAt(index);
        stringBuilder.append(c);
        letterCasePermutation(s, index + 1, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        if (c >= 'a' && c <= 'z') {
            stringBuilder.append((char) (c - 'a' + 'A'));
            letterCasePermutation(s, index + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append((char) (c - 'A' + 'a'));
            letterCasePermutation(s, index + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}
