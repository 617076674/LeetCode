package question2120;

import java.util.Arrays;

public class Solution {

  public int[] executeInstructions(int n, int[] startPos, String s) {
    int[] result = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      int[] pos = new int[2];
      pos[0] = startPos[0];
      pos[1] = startPos[1];
      result[i] = s.length() - i;
      for (int j = i; j < s.length(); j++) {
        if (s.charAt(j) == 'L') {
          pos[1]--;
        } else if (s.charAt(j) == 'R') {
          pos[1]++;
        } else if (s.charAt(j) == 'U') {
          pos[0]--;
        } else {
          pos[0]++;
        }
        if (pos[0] < 0 || pos[0] >= n || pos[1] < 0 || pos[1] >= n) {
          result[i] = j - i;
          break;
        }
      }
    }
    return result;
  }

}
