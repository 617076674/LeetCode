package question0835_image_overlap;

public class Solution {

  public int largestOverlap(int[][] A, int[][] B) {
    int N = A.length;
    int[][] count = new int[2 * N + 1][2 * N + 1];
    for (int i1 = 0; i1 < N; i1++) {
      for (int j1 = 0; j1 < N; j1++) {
        if (A[i1][j1] == 1) {
          for (int i2 = 0; i2 < N; i2++) {
            for (int j2 = 0; j2 < N; j2++) {
              if (B[i2][j2] == 1) {
                count[i1 - i2 + N][j1 - j2 + N]++;
              }
            }
          }
        }
      }
    }
    int result = 0;
    for (int[] row : count) {
      for (int v : row) {
        result = Math.max(result, v);
      }
    }
    return result;
  }

}