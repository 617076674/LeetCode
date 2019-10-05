package question1078_occurrences_after_bigram;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为text中的单词数。
 *
 * 执行用时：1ms，击败99.77%。消耗内存：34.9MB，击败100.00%。
 */
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                list.add(words[i + 2]);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
