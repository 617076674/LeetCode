package question0335_self_crossing;

public class Solution {

  public boolean isSelfCrossing(int[] distance) {
    for (int i = 3; i < distance.length; ++i) {
      if (distance[i - 1] <= distance[i - 3] && distance[i] >= distance[i - 2]) {
        return true;
      }
      if (i >= 4 && distance[i - 3] == distance[i - 1] && distance[i] + distance[i - 4] >= distance[i - 2]) {
        return true;
      }
      if (i >= 5 && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3] && distance[i - 2] > distance[i - 4] && distance[i - 3] > distance[i - 1]) {
        return true;
      }
    }
    return false;
  }

}