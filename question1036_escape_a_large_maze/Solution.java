package question1036_escape_a_large_maze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private static final int N = 1000000;

  private static final int MAX_POINTS = 19900;

  public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
    return isEscapePossibleHelper(blocked, source, target)
        && isEscapePossibleHelper(blocked, target, source);
  }

  private boolean isEscapePossibleHelper(int[][] blocked, int[] source, int[] target) {
    int cnt = 0;
    Queue<Long> queue = new LinkedList<>();
    Set<Long> visited = new HashSet<>();
    for (int[] block : blocked) {
      visited.add(position2Index(block));
    }
    cnt++;
    visited.add(position2Index(source));
    queue.add(position2Index(source));
    long targetIndex = position2Index(target);
    while (!queue.isEmpty()) {
      long curIndex = queue.poll();
      if (curIndex == targetIndex) {
        return true;
      }
      int x = (int) (curIndex / N), y = (int) (curIndex % N);
      for (int[] direction : DIRECTIONS) {
        int nextX = x + direction[0], nextY = y + direction[1];
        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
          long nextIndex = position2Index(new int[] {nextX, nextY});
          if (visited.add(nextIndex)) {
            queue.add(nextIndex);
            cnt++;
            if (cnt > MAX_POINTS) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  private static long position2Index(int[] position) {
    return (long) position[0] * N + position[1];
  }

}