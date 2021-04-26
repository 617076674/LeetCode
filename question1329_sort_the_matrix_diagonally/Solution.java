package question1329_sort_the_matrix_diagonally;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public int[][] diagonalSort(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    for (int i = 0; i < m; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j + i < m && j < n; j++) {
        list.add(mat[i + j][j]);
      }
      Collections.sort(list);
      int index = 0;
      for (int j = 0; j + i < m && j < n; j++) {
        mat[i + j][j] = list.get(index++);
      }
    }
    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j + i < n && j < m; j++) {
        list.add(mat[j][i + j]);
      }
      Collections.sort(list);
      int index = 0;
      for (int j = 0; j + i < n && j < m; j++) {
        mat[j][i + j] = list.get(index++);
      }
    }
    return mat;
  }

}