package question0850_rectangle_area_ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {

  private static int MOD = 1000000007;

  public int rectangleArea(int[][] rectangles) {
    Set<Integer> Xvals = new HashSet<>(), Yvals = new HashSet<>();

    for (int[] rec : rectangles) {
      Xvals.add(rec[0]);
      Xvals.add(rec[2]);
      Yvals.add(rec[1]);
      Yvals.add(rec[3]);
    }

    Integer[] imapx = Xvals.toArray(new Integer[0]);
    Arrays.sort(imapx);
    Integer[] imapy = Yvals.toArray(new Integer[0]);
    Arrays.sort(imapy);

    Map<Integer, Integer> mapx = new HashMap<>();
    Map<Integer, Integer> mapy = new HashMap<>();
    for (int i = 0; i < imapx.length; ++i) {
      mapx.put(imapx[i], i);
    }
    for (int i = 0; i < imapy.length; ++i) {
      mapy.put(imapy[i], i);
    }
    boolean[][] grid = new boolean[imapx.length][imapy.length];
    for (int[] rec : rectangles) {
      for (int x = mapx.get(rec[0]); x < mapx.get(rec[2]); x++) {
        for (int y = mapy.get(rec[1]); y < mapy.get(rec[3]); ++y) {
          grid[x][y] = true;
        }
      }
    }
    long ans = 0;
    for (int x = 0; x < grid.length; ++x) {
      for (int y = 0; y < grid[0].length; ++y) {
        if (grid[x][y]) {
          ans += (long) (imapx[x + 1] - imapx[x]) * (imapy[y + 1] - imapy[y]);
          ans %= MOD;
        }
      }
    }
    return (int) ans;
  }

}