package question2201;

public class Solution {

  public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
    boolean[][] isDigged = new boolean[n][n];
    for (int[] temp : dig) {
      isDigged[temp[0]][temp[1]] = true;
    }
    int res = 0;
    for (int[] artifact : artifacts) {
      boolean flag = true;
      for (int i = artifact[0]; i <= artifact[2]; i++) {
        for (int j = artifact[1]; j <= artifact[3]; j++) {
          if (!isDigged[i][j]) {
            flag = false;
            break;
          }
        }
        if (!flag) {
          break;
        }
      }
      if (flag) {
        res++;
      }
    }
    return res;
  }

}