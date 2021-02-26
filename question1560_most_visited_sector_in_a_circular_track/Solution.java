package question1560_most_visited_sector_in_a_circular_track;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> mostVisited(int n, int[] rounds) {
    int[] count = new int[n];
    int cur = rounds[0] - 1;
    count[cur]++;
    for (int i = 1; i < rounds.length; i++) {
      while (cur != rounds[i] - 1) {
        cur = (cur + 1) % n;
        count[cur]++;
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, count[i]);
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (count[i] == max) {
        result.add(i + 1);
      }
    }
    return result;
  }

}