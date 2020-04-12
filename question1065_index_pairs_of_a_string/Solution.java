package question1065_index_pairs_of_a_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 执行用时：2ms，击败100.00%。消耗内存：40.1MB，击败20.00%。
 */
public class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String word : words) {
            int i = 0, index = -1;
            while ((index = text.indexOf(word, i)) != -1) {
                list.add(new int[] {index, index + word.length() - 1});
                i = index + 1;
            }
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}