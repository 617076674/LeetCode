package question1743_restore_the_array_from_adjacent_pairs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

  public int[] restoreArray(int[][] adjacentPairs) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < adjacentPairs.length; i++) {
      if (null == map.get(adjacentPairs[i][0])) {
        map.put(adjacentPairs[i][0], new ArrayList<>());
      }
      if (null == map.get(adjacentPairs[i][1])) {
        map.put(adjacentPairs[i][1], new ArrayList<>());
      }
      map.get(adjacentPairs[i][0]).add(i);
      map.get(adjacentPairs[i][1]).add(i);
    }
    Deque<Integer> deque = new LinkedList<>();
    boolean[] visited = new boolean[adjacentPairs.length];
    for (int i = 0; i < adjacentPairs.length; i++) {
      if (i == 0) {
        deque.addLast(adjacentPairs[i][0]);
        deque.addLast(adjacentPairs[i][1]);
        visited[0] = true;
      } else {
        List<Integer> list = map.get(deque.getFirst());
        for (int index : list) {
          if (!visited[index]) {
            if (adjacentPairs[index][0] == deque.getFirst()) {
              deque.addFirst(adjacentPairs[index][1]);
            } else {
              deque.addFirst(adjacentPairs[index][0]);
            }
            visited[index] = true;
          }
        }
        list = map.get(deque.getLast());
        for (int index : list) {
          if (!visited[index]) {
            if (adjacentPairs[index][0] == deque.getLast()) {
              deque.addLast(adjacentPairs[index][1]);
            } else {
              deque.addLast(adjacentPairs[index][0]);
            }
            visited[index] = true;
          }
        }
      }
    }
    int[] result = new int[deque.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = deque.pollFirst();
    }
    return result;
  }

}