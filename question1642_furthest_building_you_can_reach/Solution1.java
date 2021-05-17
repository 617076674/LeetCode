package question1642_furthest_building_you_can_reach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {

  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    int left = 0, right = heights.length - 1;
    while (left < right) {
      if (left + 1 == right) {
        if (canReach(heights, right, bricks, ladders)) {
          return right;
        }
        return left;
      }
      int mid = left + ((right - left) >> 1);
      if (canReach(heights, mid, bricks, ladders)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private static boolean canReach(int[] heights, int target, int bricks, int ladders) {
    List<Integer> gaps = new ArrayList<>();
    for (int i = 0; i < target; i++) {
      if (heights[i + 1] > heights[i]) {
        gaps.add(heights[i + 1] - heights[i]);
      }
    }
    Collections.sort(gaps);
    int index = gaps.size() - 1;
    while (ladders-- > 0) {
      index--;
    }
    while (index >= 0) {
      bricks -= gaps.get(index);
      if (bricks < 0) {
        return false;
      }
      index--;
    }
    return true;
  }

}