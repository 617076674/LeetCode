package question1901_find_a_peak_element_ii;

public class Solution {

  private int m, n;

  public int[] findPeakGrid(int[][] mat) {
    m = mat.length;
    n = mat[0].length;
    int up = 0, down = m - 1;
    while (up <= down) {
      int mid = up + ((down - up) >> 1);
      int maxUp = mid == 0 ? -1 : maxElement(mat, mid - 1);
      int maxBottom = mid + 1 == m ? -1 : maxElement(mat, mid + 1);
      int maxIndex = maxElementIndex(mat, mid);
      if (mat[mid][maxIndex] >= Math.max(maxUp, maxBottom)) {
        return new int[] {mid, maxIndex};
      }
      if (maxUp >= Math.max(mat[mid][maxIndex], maxBottom)) {
        down = mid - 1;
      } else {
        up = mid + 1;
      }
    }
    return new int[] {};
  }

  private int maxElement(int[][] mat, int row) {
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (mat[row][i] > result) {
        result = mat[row][i];
      }
    }
    return result;
  }

  private int maxElementIndex(int[][] mat, int row) {
    int index = -1;
    for (int i = 0; i < n; i++) {
      if (index == -1 || mat[row][i] > mat[row][index]) {
        index = i;
      }
    }
    return index;
  }

}