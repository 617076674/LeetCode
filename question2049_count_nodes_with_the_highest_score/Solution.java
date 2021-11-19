package question2049_count_nodes_with_the_highest_score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private Map<Integer, List<Integer>> parent2Children = new HashMap<>();

  private Map<Integer, Long> node2Count = new HashMap<>();

  private Map<Long, Long> score2Count = new HashMap<>();

  public int countHighestScoreNodes(int[] parents) {
    for (int i = 0; i < parents.length; i++) {
      int parent = parents[i], child = i;
      List<Integer> childrenList = parent2Children.get(parent);
      if (null == childrenList) {
        childrenList = new ArrayList<>();
        childrenList.add(child);
        parent2Children.put(parent, childrenList);
      } else {
        childrenList.add(child);
      }
    }
    dfs(0);
    for (int i = 0; i < parents.length; i++) {
      if (i == 0) {
        List<Integer> childrenList = parent2Children.get(i);
        if (null == childrenList || childrenList.isEmpty()) {
          score2Count.put(0L, score2Count.getOrDefault(0, 0L) + 1);
        } else {
          long count = node2Count.get(childrenList.get(0));
          if (childrenList.size() == 2) {
            count *= node2Count.get(childrenList.get(1));
          }
          score2Count.put(count, score2Count.getOrDefault(count, 0L) + 1);
        }
      } else {
        long countParent = node2Count.get(0);
        List<Integer> childrenList = parent2Children.get(i);
        if (null == childrenList || childrenList.isEmpty()) {
          score2Count.put(countParent - 1, score2Count.getOrDefault(countParent - 1, 0L) + 1);
        } else {
          long count = node2Count.get(childrenList.get(0));
          countParent -= count + 1;
          if (childrenList.size() == 2) {
            count *= node2Count.get(childrenList.get(1));
            countParent -= node2Count.get(childrenList.get(1));
          }
          score2Count.put(count * countParent, score2Count.getOrDefault(count * countParent, 0L) + 1);
        }
      }
    }
    long max = -1, result = 0;
    for (Map.Entry<Long, Long> entry : score2Count.entrySet()) {
      if (entry.getKey() > max) {
        result = entry.getValue();
        max = entry.getKey();
      } else if (entry.getKey() == max) {
        result = entry.getValue();
      }
    }
    return (int) result;
  }

  private long dfs(int cur) {
    long result = 1;
    List<Integer> childrenList = parent2Children.get(cur);
    if (null != childrenList && !childrenList.isEmpty()) {
      for (int children : childrenList) {
        result += dfs(children);
      }
    }
    node2Count.put(cur, result);
    return result;
  }

}