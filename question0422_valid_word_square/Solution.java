package question0422_valid_word_square;

import java.util.List;

/**
 * 时间复杂度是O(m * n)，其中m是words的大小，n是words中最长字符串的长度。
 *
 * 执行用时：16ms，击败52.27%。消耗内存：36.9MB，击败100.00%。
 */
public class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.size(); j++) {
                if (i >= words.get(j).length()) {
                    break;
                }
                sb.append(words.get(j).charAt(i));
            }
            if (!words.get(i).equals(sb.toString())) {
                return false;
            }
        }
        return true;
    }
}