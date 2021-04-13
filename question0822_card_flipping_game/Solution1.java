package question0822_card_flipping_game;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

  public int flipgame(int[] fronts, int[] backs) {
    boolean[] visited = new boolean[fronts.length];
    Set<Integer> frontSet = new HashSet<>();
    for (int i = 0; i < fronts.length; i++) {
      if (fronts[i] == backs[i]) {
        visited[i] = true;
        frontSet.add(fronts[i]);
      }
    }
    while (true) {
      int cnt = 0;
      for (int i = 0; i < fronts.length; i++) {
        if (!visited[i]) {
          if (frontSet.contains(fronts[i]) && !frontSet.contains(backs[i])) {
            visited[i] = true;
          } else if (!frontSet.contains(fronts[i]) && frontSet.contains(backs[i])) {
            int temp = fronts[i];
            fronts[i] = backs[i];
            backs[i] = temp;
            frontSet.add(fronts[i]);
            cnt++;
            visited[i] = true;
          }
        }
      }
      if (cnt == 0) {
        break;
      }
    }
    for (int i = 0; i < fronts.length; i++) {
      if (!visited[i] && fronts[i] < backs[i]) {
        int temp = fronts[i];
        fronts[i] = backs[i];
        backs[i] = temp;
        frontSet.add(fronts[i]);
      }
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < backs.length; i++) {
      if (!frontSet.contains(backs[i])) {
        result = Math.min(result, backs[i]);
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }

}