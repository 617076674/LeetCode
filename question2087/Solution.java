package question2087;

public class Solution {

  public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
    if (startPos[0] == homePos[0]) {
      if (startPos[1] == homePos[1]) {
        return 0;
      }
      if (startPos[1] < homePos[1]) {
        int result = 0;
        for (int i = startPos[1] + 1; i <= homePos[1]; i++) {
          result += colCosts[i];
        }
        return result;
      }
      int result = 0;
      for (int i = startPos[1] - 1; i >= homePos[1]; i--) {
        result += colCosts[i];
      }
      return result;
    }
    if (startPos[0] < homePos[0]) {
      if (startPos[1] == homePos[1]) {
        int result = 0;
        for (int i = startPos[0] + 1; i <= homePos[0]; i++) {
          result += rowCosts[i];
        }
        return result;
      }
      if (startPos[1] < homePos[1]) {
        int result = 0;
        for (int i = startPos[0] + 1; i <= homePos[0]; i++) {
          result += rowCosts[i];
        }
        for (int i = startPos[1] + 1; i <= homePos[1]; i++) {
          result += colCosts[i];
        }
        return result;
      }
      int result = 0;
      for (int i = startPos[0] + 1; i <= homePos[0]; i++) {
        result += rowCosts[i];
      }
      for (int i = startPos[1] - 1; i >= homePos[1]; i--) {
        result += colCosts[i];
      }
      return result;
    }
    if (startPos[1] == homePos[1]) {
      int result = 0;
      for (int i = startPos[0] - 1; i >= homePos[0]; i--) {
        result += rowCosts[i];
      }
      return result;
    }
    if (startPos[1] < homePos[1]) {
      int result = 0;
      for (int i = startPos[0] - 1; i >= homePos[0]; i--) {
        result += rowCosts[i];
      }
      for (int i = startPos[1] + 1; i <= homePos[1]; i++) {
        result += colCosts[i];
      }
      return result;
    }
    int result = 0;
    for (int i = startPos[0] - 1; i >= homePos[0]; i--) {
      result += rowCosts[i];
    }
    for (int i = startPos[1] - 1; i >= homePos[1]; i--) {
      result += colCosts[i];
    }
    return result;
  }

}