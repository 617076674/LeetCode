package question1722_minimize_hamming_distance_after_swap_operations;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  
  private int[] parent;

  public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    parent = new int[source.length];
    for (int i = 0; i < source.length; i++) {
      parent[i] = i;
    }
    for (int[] swap : allowedSwaps) {
      union(swap[0], swap[1]);
    }
    Map<Integer, Map<Integer, Integer>> parent2Set = new HashMap<>();
    for (int i = 0; i < parent.length; i++) {
      int father = findParent(i);
      Map<Integer, Integer> map = parent2Set.get(father);
      if (null == map) {
        Map<Integer, Integer> temp = new HashMap<>();
        temp.put(source[i], 1);
        parent2Set.put(father, temp);
      } else {
        map.put(source[i], map.getOrDefault(source[i], 0) + 1);
      }
    }
    int result = 0;
    for (int i = 0; i < source.length; i++) {
      int father = findParent(i);
      Map<Integer, Integer> map = parent2Set.get(father);
      if (!map.containsKey(target[i])) {
        result++;
      } else {
        if (map.get(target[i]) == 1) {
          map.remove(target[i]);
        } else {
          map.put(target[i], map.get(target[i]) - 1);
        }
      }
    }
    return result;
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