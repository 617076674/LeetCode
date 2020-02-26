package question0433_minimum_genetic_mutation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 广度优先遍历。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为基因库中的基因数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.3MB，击败5.19%。
 */
public class Solution2 {
    private Map<String, Integer> stringToInteger = new HashMap<>();

    private Map<Integer, String> integerToString = new HashMap<>();

    private boolean[][] graph;

    private boolean[] visited;

    public int minMutation(String start, String end, String[] bank) {
        int index = 0;
        for (int i = 0; i < bank.length; i++) {
            if (!stringToInteger.containsKey(bank[i])) {
                stringToInteger.put(bank[i], index);
                integerToString.put(index++, bank[i]);
            }
        }
        if (!stringToInteger.containsKey(end)) {
            return -1;
        }
        if (!stringToInteger.containsKey(start)) {
            stringToInteger.put(start, index);
            integerToString.put(index++, start);
        }
        graph = new boolean[index][index];
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                if (hasPath(i, j)) {
                    graph[i][j] = graph[j][i] = true;
                }
            }
        }
        visited = new boolean[index];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(stringToInteger.get(start));
        int result = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int now = queue.poll();
                visited[now] = true;
                if (now == stringToInteger.get(end)) {
                    return result;
                }
                for (int j = 0; j < index; j++) {
                    if (graph[now][j] && !visited[j]) {
                        queue.add(j);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private boolean hasPath(int i, int j) {
        String s1 = integerToString.get(i), s2 = integerToString.get(j);
        int diff = 0;
        for (int k = 0; k < 8; k++) {
            if (s1.charAt(k) != s2.charAt(k)) {
                diff++;
            }
        }
        return diff == 1;
    }
}