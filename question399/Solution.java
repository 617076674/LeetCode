package question399;

import java.util.*;

public class Solution {

    private Map<String, Integer> stringToInteger = new HashMap<>();

    private int index = 0;

    private double[][] graph;

    private boolean[] visited;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (List<String> list : equations) {
            for (String string : list) {
                if (!stringToInteger.containsKey(string)) {
                    stringToInteger.put(string, index++);
                }
            }
        }
        graph = new double[index][index];
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String string0 = list.get(0), string1 = list.get(1);
            int index1 = stringToInteger.get(string0), index2 = stringToInteger.get(string1);
            graph[index1][index2] = values[i];
            graph[index2][index1] = 1.0 / values[i];
        }
        double[] result = new double[queries.size()];
        Arrays.fill(result, -1.0);
        for (int i = 0; i < result.length; i++) {
            List<String> list = queries.get(i);
            String string0 = list.get(0), string1 = list.get(1);
            if (stringToInteger.containsKey(string0) && stringToInteger.containsKey(string1)) {
                if (string0.equals(string1)) {
                    result[i] = 1.0;
                } else {
                    int index1 = stringToInteger.get(string0), index2 = stringToInteger.get(string1);
                    visited = new boolean[index];
                    double len = 1.0;
                    dfs(index1, index2, len, result, i);
                }
            }
        }
        return result;
    }

    private void dfs(int begin, int end, double len, double[] result, int k) {
        if (graph[begin][end] == 0) {
            visited[begin] = true;
            for (int i = 0; i < index; i++) {
                if (!visited[i] && graph[begin][i] != 0) {
                    dfs(i, end, len * graph[begin][i], result, k);
                }
            }
        } else {
            result[k] = len * graph[begin][end];
        }
    }

}
