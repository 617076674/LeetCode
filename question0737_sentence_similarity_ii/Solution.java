package question0737_sentence_similarity_ii;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 words1、 words2 和 pairs 中出现的字符的数量。
 *
 * 执行用时：32ms，击败73.95%。消耗内存：40.8MB，击败100.00%。
 */
public class Solution {
    private Map<String, Integer> map = new HashMap<>();

    private int[] parent;

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1 == null && words2 == null) {
            return true;
        }
        if (words1 == null || words2 == null) {
            return false;
        }
        if (words1.length != words2.length) {
            return false;
        }
        int index = 0;
        for (String word : words1) {
            if (!map.containsKey(word)) {
                map.put(word, index++);
            }
        }
        for (String word : words2) {
            if (!map.containsKey(word)) {
                map.put(word, index++);
            }
        }
        for (List<String> pair : pairs) {
            for (String word : pair) {
                if (!map.containsKey(word)) {
                    map.put(word, index++);
                }
            }
        }
        parent = new int[map.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (List<String> pair : pairs) {
            String word1 = pair.get(0), word2 = pair.get(1);
            union(map.get(word1), map.get(word2));
        }
        for (int i = 0; i < words1.length; i++) {
            if (findParent(map.get(words1[i])) != findParent(map.get(words2[i]))) {
                return false;
            }
        }
        return true;
    }

    private void union(int a, int b) {
        int aParent = findParent(a), bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }

    private int findParent(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        while (a != parent[a]) {
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }
}