package question0399_evaluate_division;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private Map<String, Integer> stringToInteger = new HashMap<>();

  private int index;

  private double[][] graph;

  private boolean[] visited;

  public double[] calcEquation(List<List<String>> equations, double[] values,
                               List<List<String>> queries) {
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
        int index1 = stringToInteger.get(string0), index2 = stringToInteger.get(string1);
        visited = new boolean[index];
        result[i] = dfs(index1, index2);
      }
    }
    return result;
  }

  private double dfs(int begin, int end) {
    if (begin == end) {
      return 1.0;
    }
    visited[begin] = true;
    double result = -1.0;
    for (int i = 0; i < index; i++) {
      if (!visited[i] && graph[begin][i] != 0) {
        double tmp = dfs(i, end);
        if (tmp > 0) {
          return tmp * graph[begin][i];
        }
      }
    }
    return result;
  }

}