package question1258_synonymous_sentences;

import java.util.*;

/**
 * 并查集+回溯
 *
 * 执行用时：5ms，击败35.87%。消耗内存：40.1MB，击败100.00%。
 */
public class Solution {
    private Map<String, Integer> stringToInt = new HashMap<>();

    private int count;

    private int[] parent;

    private Set<String> result = new TreeSet<>();

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        for (List<String> list : synonyms) {
            for (String s : list) {
                if (!stringToInt.containsKey(s)) {
                    stringToInt.put(s, count);
                    count++;
                }
            }
        }
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
        for (List<String> list : synonyms) {
            int num1 = stringToInt.get(list.get(0)), num2 = stringToInt.get(list.get(1));
            union(num1, num2);
        }
        generateSentences(text.split(" "), 0);
        return new ArrayList<>(result);
    }

    private int findParent(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        //路径压缩
        while (a != parent[a]) {
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }

    private void union(int a, int b) {
        int aParent = findParent(a), bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }

    private void generateSentences(String[] strings, int index) {
        if (index == strings.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                sb.append(strings[i]);
                if (i != strings.length - 1) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
            return;
        }
        generateSentences(strings, index + 1);
        String tmp = strings[index];
        if (stringToInt.containsKey(tmp)) {
            int num1 = stringToInt.get(tmp);
            for (String s : stringToInt.keySet()) {
                int num2 = stringToInt.get(s);
                if (findParent(num1) == findParent(num2)) {
                    strings[index] = s;
                    generateSentences(strings, index + 1);
                    strings[index] = tmp;
                }
            }
        }
    }
}