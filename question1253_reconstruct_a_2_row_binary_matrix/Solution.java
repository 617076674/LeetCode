package question1253_reconstruct_a_2_row_binary_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    int[][] matrix = new int[2][colsum.length];
    for (int i = 0; i < colsum.length; i++) {
      if (colsum[i] == 2) {
        matrix[0][i] = matrix[1][i] = 1;
        upper--;
        lower--;
      }
    }
    if (lower < 0 || upper < 0) {
      return new ArrayList<>();
    }
    for (int i = 0; i < colsum.length; i++) {
      if (colsum[i] == 1) {
        if (upper > 0) {
          matrix[0][i] = 1;
          upper--;
        } else {
          matrix[1][i] = 1;
          lower--;
        }
      }
    }
    if (upper != 0 || lower != 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < matrix[0].length; j++) {
        list.add(matrix[i][j]);
      }
      result.add(list);
    }
    return result;
  }

}