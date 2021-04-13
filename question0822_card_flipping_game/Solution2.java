package question0822_card_flipping_game;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

  public int flipgame(int[] fronts, int[] backs) {
    Set<Integer> same = new HashSet<>();
    for (int i = 0; i < fronts.length; i++) {
      if (fronts[i] == backs[i]) {
        same.add(fronts[i]);
      }
    }
    int result = Integer.MAX_VALUE;
    for (int front : fronts) {
      if (!same.contains(front)) {
        result = Math.min(result, front);
      }
    }
    for (int back : backs) {
      if (!same.contains(back)) {
        result = Math.min(result, back);
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }

}