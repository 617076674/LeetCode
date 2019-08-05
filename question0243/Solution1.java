package question0243;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-08-04
 *
 * 用HashMap保存各个单词的索引，由于可能一个单词重复出现，所以每个单词对应的是一个索引list。
 *
 * 时间复杂度O(max(n, n1 * n2))，其中n是words数组的长度，n1是word1单词在words数组中重复出现的次数，
 * n2是word2单词在words数组中重复出现的次数。空间复杂度是O(n)。
 *
 * 执行用时：13ms，击败10.00%。消耗内存：40.1MB，击败100.00%。
 */
public class Solution1 {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
        //暴力破解
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                result = Math.min(result, Math.abs(list1.get(i) - list2.get(j)));
            }
        }
        return result;
    }
}
