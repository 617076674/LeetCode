package question2056;

public class Solution {

  private int result;

  private static int[][] directions =
      new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

  private int[][] selectedDirections;

  private static final String QUEEN = "queen";

  private static final String BISHOP = "bishop";

  private int[][] positions;

  public int countCombinations(String[] pieces, int[][] positions) {
    int n = pieces.length;
    selectedDirections = new int[n][];
    for (int i = 0; i < n; i++) {
      switch (pieces[i]) {
        case QUEEN:
          selectedDirections[i] = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
          break;
        case BISHOP:
          selectedDirections[i] = new int[] {4, 5, 6, 7};
          break;
        default:
          selectedDirections[i] = new int[] {0, 1, 2, 3};
      }
    }
    this.positions = positions;
    dfs(new int[n], new int[n], 0);
    return result;
  }

  private static boolean check(int[][] positions) {
    for (int i = 0; i < positions.length; i++) {
      for (int j = 0; j < positions.length; j++) {
        if (i == j) {
          continue;
        }
        if (positions[i][0] == positions[j][0] && positions[i][1] == positions[j][1]) {
          return false;
        }
      }
    }
    return true;
  }

  private void dfs(int[] dirIndexes, int[] step, int index) {
    if (index == positions.length) {
      int t = 0;
      int[][] curPositions = new int[positions.length][2];
      for (int i = 0; i < curPositions.length; i++) {
        System.arraycopy(positions[i], 0, curPositions[i], 0, 2);
      }
      boolean flag = true;
      while (flag) {
        flag = false;
        for (int i = 0; i < curPositions.length; i++) {
          if (t < step[i]) {
            curPositions[i][0] += directions[dirIndexes[i]][0];
            curPositions[i][1] += directions[dirIndexes[i]][1];
            flag = true;
          }
        }
        if (!check(curPositions)) {
          return;
        }
        t++;
      }
      result++;
      return;
    }
    dfs(dirIndexes, step, index + 1);
    for (int i = 0; i < selectedDirections[index].length; i++) {
      int j = selectedDirections[index][i];
      for (int num = 1; num < 8; num++) {
        int x = positions[index][0] + directions[j][0] * num, y =
            positions[index][1] + directions[j][1] * num;
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
          dirIndexes[index] = j;
          step[index] = num;
          dfs(dirIndexes, step, index + 1);
          dirIndexes[index] = 0;
          step[index] = 0;
        } else {
          break;
        }
      }
    }
  }

}