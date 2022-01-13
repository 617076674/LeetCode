package question0846_hand_of_straights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

  public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) {
      return false;
    }
    Arrays.sort(hand);
    Map<Integer, List<Integer>> num2Indexes = new HashMap<>();
    for (int i = hand.length - 1; i >= 0; i--) {
      num2Indexes.computeIfAbsent(hand[i], k -> new ArrayList<>()).add(i);
    }
    boolean[] visited = new boolean[hand.length];
    int groupCnt = 0;
    for (int i = 0; i < hand.length; i++) {
      if (visited[i]) {
        continue;
      }
      groupCnt++;
      if (groupCnt > hand.length / groupSize) {
        return false;
      }
      for (int j = hand[i]; j < hand[i] + groupSize; j++) {
        List<Integer> indexes = num2Indexes.get(j);
        if (null == indexes || indexes.isEmpty()) {
          return false;
        }
        visited[indexes.remove(indexes.size() - 1)] = true;
      }
    }
    return groupCnt == hand.length / groupSize;
  }

}