package lcci1726_sparse_similarity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public List<String> computeSimilarities(int[][] docs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                Set<Integer> set = map.get(docs[i][j]);
                if (null == set) {
                    set = new HashSet<>();
                    set.add(i);
                    map.put(docs[i][j], set);
                } else {
                    set.add(i);
                }
            }
        }
        int[][] graph = new int[docs.length][docs.length];
        for (Set<Integer> set : map.values()) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    graph[list.get(i)][list.get(j)]++;
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < docs.length; i++) {
            for (int j = i + 1; j < docs.length; j++) {
                if (graph[i][j] > 0) {
                    result.add(String.format("%d,%d: %.4f", i, j, graph[i][j] * 1.0 / (docs[i].length + docs[j].length - graph[i][j])));
                }
            }
        }
        return result;
    }

}