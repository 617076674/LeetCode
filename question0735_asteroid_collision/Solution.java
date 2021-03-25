package question0735_asteroid_collision;

import java.util.LinkedList;

public class Solution {

  public int[] asteroidCollision(int[] asteroids) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int asteroid : asteroids) {
      boolean need = true;
      while (!linkedList.isEmpty() && linkedList.peekLast() > 0 && asteroid < 0) {
        if (Math.abs(asteroid) > Math.abs(linkedList.peekLast())) {
          linkedList.pollLast();
        } else if (Math.abs(asteroid) == Math.abs(linkedList.peekLast())) {
          linkedList.pollLast();
          need = false;
          break;
        } else {
          need = false;
          break;
        }
      }
      if (need) {
        linkedList.addLast(asteroid);
      }
    }
    int[] result = new int[linkedList.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = linkedList.pollFirst();
    }
    return result;
  }

}