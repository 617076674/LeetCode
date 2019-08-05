package question0244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构造函数的时间复杂度是O(n)，其中n为words数组的长度。
 * shortest()函数的时间复杂度都是O(max(p, k))，其中p为word1出现的次数，k为word2出现的次数。
 *
 * 执行用时：149ms，击败80.95%。消耗内存：54.7MB，击败100.00%。
 */
public class WordDistance2 {
    private Map<String, List<Integer>> map;

    public WordDistance2(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        int index1 = 0, index2 = 0, minDiff = Integer.MAX_VALUE;
        while (index1 < list1.size() && index2 < list2.size()) {
            minDiff = Math.min(minDiff, Math.abs(list1.get(index1) - list2.get(index2)));
            if (list1.get(index1) < list2.get(index2)) {
                index1++;
            } else {
                index2++;
            }
        }
        return minDiff;
    }
}