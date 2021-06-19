package question1886_determine_whether_matrix_can_be_obtained_by_rotation;

public class Solution {

  private int n;

  public boolean findRotation(int[][] mat, int[][] target) {
    n = mat.length;
    for (int i = 0; i < 4; i++) {
      if (isSame(mat, target, i)) {
        return true;
      }
    }
    return false;
  }

  private boolean isSame(int[][] mat, int[][] target, int turns) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int[] position = new int[] {i, j};
        for (int k = 0; k < turns; k++) {
          turnRight(position);
        }
        if (target[position[0]][position[1]] != mat[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  private void turnRight(int[] position) {
    int x = position[0], y = position[1];
    position[0] = y;
    position[1] = n - 1 - x;
  }

}