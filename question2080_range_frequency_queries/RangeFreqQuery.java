package question2080_range_frequency_queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {

  private Map<Integer, List<Integer>> num2PositionList = new HashMap<>();

  public RangeFreqQuery(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      List<Integer> positionList = num2PositionList.get(arr[i]);
      if (null == positionList) {
        positionList = new ArrayList<>();
        positionList.add(i);
        num2PositionList.put(arr[i], positionList);
      } else {
        positionList.add(i);
      }
    }
  }

  public int query(int left, int right, int value) {
    List<Integer> positionList = num2PositionList.get(value);
    if (null == positionList) {
      return 0;
    }
    int floorIndex = floor(positionList, left);
    int realLeft;
    if (floorIndex == -1) {
      realLeft = 0;
    } else if (positionList.get(floorIndex) == left) {
      realLeft = floorIndex;
    } else {
      realLeft = floorIndex + 1;
    }
    int ceilIndex = ceil(positionList, right);
    int realRight;
    if (ceilIndex == positionList.size()) {
      realRight = positionList.size() - 1;
    } else if (positionList.get(ceilIndex) == right) {
      realRight = ceilIndex;
    } else {
      realRight = ceilIndex - 1;
    }
    return realRight - realLeft + 1;
  }

  private static int floor(List<Integer> nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums.get(mid) >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left < nums.size() && nums.get(left) == target) {
      return left;
    }
    return right;
  }

  private static int ceil(List<Integer> nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums.get(mid) <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (right >= 0 && nums.get(right) == target) {
      return right;
    }
    return left;
  }


}