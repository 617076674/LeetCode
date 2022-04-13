package question2211;

public class Solution {

  public int countCollisions(String directions) {
    boolean[] rightEnable = new boolean[directions.length()];
    // rightEnable[i] = true 表示在 [i + 1, directions.length - 1] 范围内存在 S 或 L
    for (int i = rightEnable.length - 2; i >= 0; i--) {
      char c = directions.charAt(i + 1);
      if (c == 'S' || c == 'L') {
        rightEnable[i] = true;
      } else {
        rightEnable[i] = rightEnable[i + 1];
      }
    }
    boolean leftEnable = false;
    int result = 0;
    for (int i = 0; i < directions.length(); i++) {
      char c = directions.charAt(i);
      if ((c == 'R' && rightEnable[i]) || (c == 'L' && leftEnable)) {
        result++;
      }
      if (c == 'S' || c == 'R') {
        leftEnable = true;
      }
    }
    return result;
  }

}