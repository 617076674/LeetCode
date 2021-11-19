package lcp39_0jQkd0;

public class Solution {

  public int minimumSwitchingTimes(int[][] source, int[][] target) {
      int[] map1 = colorCount(source), map2 = colorCount(target);
      int result = 0;
      for (int i = 0; i < map1.length; i++) {
          result += Math.max(map1[i], map2[i]) - Math.min(map1[i], map2[i]);
      }
      return result / 2;
  }

  private static int[] colorCount(int[][] graph) {
    int[] map = new int[10001];
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        map[graph[i][j]]++;
      }
    }
    return map;
  }

}