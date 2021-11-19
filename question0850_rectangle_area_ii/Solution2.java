package question0850_rectangle_area_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

  private static int MOD = 1000000007;

  public int rectangleArea(int[][] rectangles) {
    int open = 0, close = 1;
    int[][] events = new int[rectangles.length * 2][];
    int t = 0;
    for (int[] rec : rectangles) {
      events[t++] = new int[] {rec[1], open, rec[0], rec[2]};
      events[t++] = new int[] {rec[3], close, rec[0], rec[2]};
    }
    Arrays.sort(events, Comparator.comparingInt(event -> event[0]));
    List<int[]> actives = new ArrayList<>();
    int curY = events[0][0];
    long ans = 0;
    for (int[] event : events) {
      int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];
      // Calculate query
      long query = 0;
      int cur = -1;
      for (int[] xs : actives) {
        cur = Math.max(cur, xs[0]);
        query += Math.max(xs[1] - cur, 0);
        cur = Math.max(cur, xs[1]);
      }

      ans += query * (y - curY);

      if (typ == open) {
        actives.add(new int[] {x1, x2});
        Collections.sort(actives, Comparator.comparingInt(active -> active[0]));
      } else {
        for (int i = 0; i < actives.size(); i++) {
          if (actives.get(i)[0] == x1 && actives.get(i)[1] == x2) {
            actives.remove(i);
            break;
          }
        }
      }
      curY = y;
    }
    ans %= MOD;
    return (int) ans;
  }

}