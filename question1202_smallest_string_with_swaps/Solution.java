package question1202_smallest_string_with_swaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    private int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        Map<Integer, Map<Character, Integer>> parent2Set = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int father = findParent(i);
            Map<Character, Integer> map = parent2Set.get(father);
            if (null == map) {
                Map<Character, Integer> temp = new TreeMap<>();
                temp.put(s.charAt(i), 1);
                parent2Set.put(father, temp);
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parent.length; i++) {
            int father = findParent(i);
            Map<Character, Integer> map = parent2Set.get(father);
            char c = map.keySet().iterator().next();
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private int findParent(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        while (a != parent[a]) {
            int z = parent[a];
            parent[a] = x;
            a = z;
        }
        return x;
    }

    private void union(int a, int b) {
        int aParent = findParent(a), bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }

}