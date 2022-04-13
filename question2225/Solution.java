package question2225;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<Integer>> findWinners(int[][] matches) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> winners = new ArrayList<>(), oneLosers = new ArrayList<>();
    Map<Integer, Integer> id2LoseCnt = new HashMap<>();
    for (int[] match : matches) {
      int win = match[0], lose = match[1];
      id2LoseCnt.put(lose, id2LoseCnt.getOrDefault(lose, 0) + 1);
      id2LoseCnt.put(win, id2LoseCnt.getOrDefault(win, 0));
    }
    for (Map.Entry<Integer, Integer> entry : id2LoseCnt.entrySet()) {
      if (entry.getValue().intValue() == 0) {
        winners.add(entry.getKey());
      } else if (entry.getValue().intValue() == 1) {
        oneLosers.add(entry.getKey());
      }
    }
    Collections.sort(winners);
    Collections.sort(oneLosers);
    res.add(winners);
    res.add(oneLosers);
    return res;
  }

}