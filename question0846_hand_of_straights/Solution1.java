package question0846_hand_of_straights;

import java.util.TreeMap;

public class Solution1 {

  public boolean isNStraightHand(int[] hand, int W) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int card : hand) {
      map.put(card, map.getOrDefault(card, 0) + 1);
    }
    while (!map.isEmpty()) {
      int first = map.firstKey();
      for (int card = first; card < first + W; ++card) {
        if (!map.containsKey(card)) {
          return false;
        }
        int c = map.get(card);
        if (c == 1) {
          map.remove(card);
        } else {
          map.put(card, c - 1);
        }
      }
    }
    return true;
  }

}