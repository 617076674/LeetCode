package question2115;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Map<String, Integer> name2Index = new HashMap<>();
    Map<Integer, String> index2Name = new HashMap<>();
    int index = 0;
    for (String name : recipes) {
      if (!name2Index.containsKey(name)) {
        name2Index.put(name, index);
        index2Name.put(index, name);
        index++;
      }
    }
    for (List<String> ingredient : ingredients) {
      for (String name : ingredient) {
        if (!name2Index.containsKey(name)) {
          name2Index.put(name, index);
          index2Name.put(index, name);
          index++;
        }
      }
    }
    for (String name : supplies) {
      if (!name2Index.containsKey(name)) {
        name2Index.put(name, index);
        index2Name.put(index, name);
        index++;
      }
    }
    int[] inDegree = new int[index];
    boolean[][] graph = new boolean[index][index];
    for (int i = 0; i < ingredients.size(); i++) {
      int to = name2Index.get(recipes[i]);
      for (String name : ingredients.get(i)) {
        int from = name2Index.get(name);
        graph[from][to] = true;
        inDegree[to]++;
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    for (String name : supplies) {
      queue.add(name2Index.get(name));
    }
    Set<String> result = new HashSet<>();
    Set<String> set = new HashSet<>();
    for (String name : recipes) {
      set.add(name);
    }
    for (String name : supplies) {
      if (set.contains(name)) {
        result.add(name);
      }
    }
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int i = 0; i < graph[cur].length; i++) {
        if (graph[cur][i]) {
          inDegree[i]--;
          if (inDegree[i] == 0) {
            queue.add(i);
            if (set.contains(index2Name.get(i))) {
              result.add(index2Name.get(i));
            }
          }
        }
      }
    }
    return new ArrayList<>(result);
  }

}