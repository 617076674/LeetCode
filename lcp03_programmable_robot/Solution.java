package lcp03_programmable_robot;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public boolean robot(String command, int[][] obstacles, int x, int y) {
    long curX = 0, curY = 0;
    Set<Long> set = new HashSet<>();
    set.add((curX << 32) | curY);
    for (int i = 0; i < command.length(); i++) {
      if (command.charAt(i) == 'U') {
        curY++;
      } else {
        curX++;
      }
      set.add((curX << 32) | curY);
    }
    long turns = Math.min(x / curX, y / curY);
    if (!set.contains(((x - turns * curX) << 32) | (y - turns * curY))) {
      return false;
    }
    for (int[] obstacle : obstacles) {
      if (obstacle[0] > x || obstacle[1] > y) {
        continue;
      }
      turns = Math.min(obstacle[0] / curX, obstacle[1] / curY);
      if (set.contains(((obstacle[0] - turns * curX) << 32) | (obstacle[1] - turns * curY))) {
        return false;
      }
    }
    return true;
  }

}