package question0433_minimum_genetic_mutation;

import java.util.HashMap;
import java.util.Map;

/**
 * 深度优先遍历。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为基因库中的基因数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.3MB，击败5.19%。
 */
public class Solution1 {
    private Map<String, Integer> stringToInteger = new HashMap<>();

    private Map<Integer, String> integerToString = new HashMap<>();

    private boolean[][] graph;

    private boolean[] visited;

    private int result = Integer.MAX_VALUE;

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
        dfs(stringToInteger.get(start), stringToInteger.get(end), 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(int now, int terminal, int step) {
        if (now == terminal) {
            result = Math.min(result, step);
            return;
        }
        for (int i = 0; i < graph.length; i++) {
            if (graph[now][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, terminal, step + 1);
                visited[i] = false;
            }
        }
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