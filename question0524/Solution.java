package question0524;

import java.util.List;

/**
 * 双指针。
 *
 * 遍历d中的每一个String元素，寻找最长的且和s相匹配的。
 *
 * 时间复杂度是O(n * m)，其中n为d中的字符串数量，m为d中字符串的平均长度。
 *
 * 执行用时：75ms，击败33.28%。消耗内存：49MB，击败52.20%。
 */
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String tmp : d) {
            if ((tmp.length() > result.length() || (tmp.length() == result.length() && tmp.compareTo(result) < 0))
                    && match(s, tmp)) {
                result = tmp;
            }
        }
        return result;
    }

    private boolean match(String s1, String s2) {
        int index = 0;
        for (int i = 0; i < s2.length(); i++) {
            while (index < s1.length() && s2.charAt(i) != s1.charAt(index)) {
                index++;
            }
            if (index >= s1.length()) {
                return false;
            } else {
                index++;
            }
        }
        return true;
    }
}
