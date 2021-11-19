package question1610;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
    List<Double> angleList = new ArrayList<>(points.size());
    int extra = 0;
    for (List<Integer> point : points) {
      int deltaY = point.get(1) - location.get(1), deltaX = point.get(0) - location.get(0);
      if (deltaY == 0 && deltaX == 0) {
        extra++;
        continue;
      }
      double curAngle = Math.atan2(deltaY, deltaX);
      angleList.add(curAngle);
      angleList.add(curAngle + 2 * Math.PI);
    }
    Collections.sort(angleList);
    double maxAngle = angle * Math.PI / 180;
    int left = 0, right = -1, result = 0;
    while (right + 1 < angleList.size()) {
      right++;
      while (angleList.get(right) - angleList.get(left) > maxAngle) {
        left++;
      }
      result = Math.max(result, right - left + 1);
    }
    return result + extra;
  }

}