package question1921_eliminate_maximum_number_of_monsters;

import java.util.Arrays;

public class Solution {

  public int eliminateMaximum(int[] dist, int[] speed) {
    Integer[] indexes = new Integer[dist.length];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, (id1, id2) -> {
      double t1 = dist[id1] * 1.0 / speed[id1], t2 = dist[id2] * 1.0 / speed[id2];
      return Double.compare(t1, t2);
    });
    int time = 0, index = 0;
    while (index < dist.length) {
        if (time >= dist[indexes[index]] * 1.0 / speed[indexes[index]]) {
            return index;
        }
        time++;
        index++;
    }
    return dist.length;
  }

}