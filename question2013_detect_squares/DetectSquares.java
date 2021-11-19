package question2013_detect_squares;

public class DetectSquares {

  private int[][] graph = new int[1001][1001];

  public DetectSquares() {

  }

  public void add(int[] point) {
    graph[point[0]][point[1]]++;
  }

  public int count(int[] point) {
    int x = point[0], y = point[1];
    int result = 0;
    for (int i = 0; i < 1001; i++) {
      if (i == x) {
        continue;
      }
      int len = Math.abs(i - x);
      if (y - len >= 0) {
        result += graph[i][y] * graph[x][y - len] * graph[i][y - len];
      }
      if (y + len < 1001) {
        result += graph[i][y] * graph[x][y + len] * graph[i][y + len];
      }
    }
    return result;
  }

}