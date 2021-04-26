package question1041_robot_bounded_in_circle;

public class Solution {

  public boolean isRobotBounded(String instructions) {
    int x = 0, y = 0, direction = 3;
    for (int i = 0; i < instructions.length(); i++) {
      char c = instructions.charAt(i % instructions.length());
      if (c == 'G') {
        if (direction == 0) {
          x++;
        } else if (direction == 1) {
          y--;
        } else if (direction == 2) {
          x--;
        } else {
          y++;
        }
      } else if (c == 'L') {
        direction = (direction + 3) % 4;
      } else {
        direction = (direction + 1) % 4;
      }
    }
    return (x == 0 && y == 0) || direction != 3;
  }

}