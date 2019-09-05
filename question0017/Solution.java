package question0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 回溯法。
 *
 * 时间复杂度是O(3 ^ n)，其中n为字符串digits的长度。空间复杂度是O(n)。
 *
 * 执行用时：2ms，击败77.60%。消耗内存：35.9MB，击败74.38%。
 */
public class Solution {
    private List<String> list = new ArrayList<>();

    private Map<Character, String> map = new HashMap<>();

    private int n;

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (null == digits || (n = digits.length()) == 0) {
            return list;
        }
        letterCombinations(digits, 0, new StringBuilder());
        return list;
    }

    private void letterCombinations(String digits, int index, StringBuilder sb) {
        if (index == n) {
            list.add(sb.toString());
            return;
        }
        char[] nextChar = map.get(digits.charAt(index)).toCharArray();
        for (int i = 0; i < nextChar.length; i++) {
            sb.append(nextChar[i]);
            letterCombinations(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}