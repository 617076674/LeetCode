package question2139;

public class Solution {

  public int minMoves(int target, int maxDoubles) {
    if (target == 1) {
      return 0;
    }
    if (maxDoubles == 0) {
      return target - 1;
    }
    if (target % 2 == 0) {
      return minMoves(target / 2, maxDoubles - 1) + 1;
    }
    return minMoves(target - 1, maxDoubles) + 1;
  }

}