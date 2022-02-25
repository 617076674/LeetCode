package question0531;

public class Solution {

  public int findLonelyPixel(char[][] picture) {
    int m = picture.length;
    int n = picture[0].length;
    int[] row2BCnt = new int[m], col2BCnt = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] == 'B') {
          row2BCnt[i]++;
          col2BCnt[j]++;
        }
      }
    }
    int result = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] == 'B' && row2BCnt[i] == 1 && col2BCnt[j] == 1) {
          result++;
        }
      }
    }
    return result;
  }

}